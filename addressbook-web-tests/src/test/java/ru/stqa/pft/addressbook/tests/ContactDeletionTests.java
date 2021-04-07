package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod

  public void ensurePreconditions() {

    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));

    }

    app.goTo().HomePageInHeader();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("First name")
              .withLastName("Last name")
              .withPhone_number("+89263124567")
              .withEmail("zabavaltd@gmail.com")
              .withGroup_name("test1"));
    }

  }


  @Test (enabled = true)

  public void testContactDeletion() throws Exception {


    app.goTo().HomePageInHeader();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next(); // обращаемся к множеству через итератор и используем метод next чтобы вернуть первый попавшийся элемент множества
    app.contact().delete(deletedContact);
    app.goTo().HomePageInHeader();
    assertThat(app.contact().count(), equalTo(before.size() - 1));//забираем из хеша данные чтобы не создавать список заново
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

  }

}
