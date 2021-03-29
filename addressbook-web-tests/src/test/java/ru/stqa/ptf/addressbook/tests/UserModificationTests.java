package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;
import ru.stqa.ptf.addressbook.model.UserData;
import ru.stqa.ptf.addressbook.model.Users;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoHomePage();
        if (app.user().all().size()==0) {
            app.user().create(new UserData().withFirstName("Lexa").withLastName("Vasiliev").withHome("Moscow"));
        }
    }

    @Test
    public void testUserModification() {

        Users before = app.user().all();
        UserData modifyUser = before.iterator().next();

        UserData user = new UserData().withId(modifyUser.getId()).withFirstName("Vana").withLastName("Durkov").withHome("Omsk");
        app.user().modify(user);
        Users after = app.user().all();


        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(modifyUser).withAdded(user)));

    }
}
