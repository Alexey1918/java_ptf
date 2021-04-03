package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {

  app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));}

  }

  @Test (enabled = true)
  public void testContactCreation() throws Exception {



    app.goTo().HomePageInHeader();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resurses/stru.png");
    ContactData contact = new ContactData()
            .withFirstName("Vasiliy")
            .withLastName("Zaizev")
            .withPhone_number("+89263124567")
            .withEmail("zabavaltd@gmail.com")
            .withGroup_name("test1")
            .withPhoto(photo);

      app.contact().create(contact);

    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

}
