package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {


        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        app.goTo().HomePageInHeader();

        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirst_name("First name")
                    .withLast_name("Last name")
                    .withMobilePhone("+375290000000")
                    .withEmail("dummyemail@gmail.com"));
            //.withGroup_name("test1"));
        }
    }

    @Test

    public void testContactAddToGroup() {

        app.goTo().HomePageInHeader();
        ContactData addContact = selectContact();
        GroupData groupContactToBeAddedTo = selectGroup(addContact);//контакт дорбален в группу 2 ранее выбранную
        Groups before = addContact.getGroups();//получить группу в которую добален контакт
        app.goTo().HomePageInHeader();
        app.contact().addContactToGroup(addContact, groupContactToBeAddedTo);
        app.goTo().HomePageInHeader();
        ContactData addContactAfter = selectContactById(addContact);//получили контакт по ID из всех контактов
        Groups after = addContactAfter.getGroups();
        assertThat(after, equalTo(before.withAdded(groupContactToBeAddedTo)));
    }

    private ContactData selectContactById(ContactData addContact) {
        Contacts allContacts     = app.db().contacts();
        int a = addContact.getId();
        System.out.println("Искомая айди -" + a);

        for (ContactData r : allContacts){
            if (a == r.getId()) {
                System.out.println("Контакт с нужной айди - " + r);
                return r;
            }
        }return null;
    }

    private GroupData selectGroup(ContactData contact) {
        Groups allGroups = app.db().groups();//группы перед добавлением
        Groups contactsInGroups = contact.getGroups();

        Collection<GroupData> contactGroups = new HashSet<>(contactsInGroups);
        Collection<GroupData> avaliableGroups = new HashSet<>(allGroups);
        avaliableGroups.removeAll(contactGroups);
        return avaliableGroups.iterator().next();//случайно выбрали вторую группу
    }


    private ContactData selectContact() {

        Contacts allContacts = app.db().contacts();
        Groups allGroups = app.db().groups();
        for (ContactData contact : allContacts) {
            if (contact.getGroups().size() < allGroups.size()) {
                return contact;
            }
        }
        app.goTo().GroupPage();
        app.group().create(new GroupData().withName("group created by test").withHeader("header for group from test"));
        return allContacts.iterator().next();
    }
}