package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactRemoveFromGroupTests extends TestBase{

    @BeforeMethod

    public void ensurePreconditions() {

        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirst_name("First name")
                    .withLast_name("Last name")
                    .withMobilePhone("+375290000000")
                    .withEmail("dummyemail@gmail.com"));
        }
    }

    @Test

    public void testContactRemoveFromGroup() {

        app.goTo().HomePageInHeader();
        ContactData contact = selectContact();
        GroupData groupContactToRemovedFrom = selectGroup(contact);
        Groups before = contact.getGroups();
        app.goTo().HomePageInHeader();
        app.contact().selectGroupFromList(groupContactToRemovedFrom.getId());
        app.contact().removeContactFromGroup(contact, groupContactToRemovedFrom);
        ContactData contactsAfter = selectContactById(contact);
        Groups after = contactsAfter.getGroups();
        assertThat(after, equalTo(before.without(groupContactToRemovedFrom)));

    }

    private ContactData selectContactById(ContactData addContact) {
        Contacts allContacts     = app.db().contacts();
        int a = addContact.getId();
        System.out.println("Искомая айди -" + a);

        //allContacts.stream().filter(c ->c.getId() == a);

        for (ContactData r : allContacts){
            if (a == r.getId()) {
                System.out.println("Контакт с нужной айди - " + r);
                return r;
            }
        }return null;
    }


    private GroupData selectGroup(ContactData removeContact) {

        ContactData contact = selectContactById(removeContact);
        Groups contactToBeRemoved =  contact.getGroups();
        return contactToBeRemoved.iterator().next();

    }

    private ContactData selectContact() {
        Contacts allContacts = app.db().contacts();
        for (ContactData contact : allContacts) {
            if (contact.getGroups().size() > 0) {
                return contact;
            }
        }

        ContactData addContact = app.db().contacts().iterator().next();
        app.contact().addContactToGroup(addContact, app.db().groups().iterator().next());
        return addContact;
    }

}