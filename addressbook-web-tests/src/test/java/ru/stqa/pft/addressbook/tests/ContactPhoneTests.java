package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

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
              .withPhone_number("+892616601234")
              .withEmail("alexvin@gmail.com")
              .withGroup_name("test1"));
    }

  }

  @Test

  public void testContactPhones() {
    app.goTo().HomePageInHeader();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getMainAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter(s -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(),contact.getEmail2(), contact.getEmail3())
            .stream().filter(s -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getEditAddress())
            .stream().filter(s -> ! s.equals(""))
            //.map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
