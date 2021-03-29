package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.UserData;
import java.util.HashSet;
import java.util.List;

public class UserModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoHomePage();
        if (app.user().userList().size()==0) {
            app.user().create(new UserData("Elena", null, "892616601235"));
        }
    }

    @Test
    public void testUserModification() {

        List<UserData> before = app.user().userList();
        int index = before.size()-1;
        UserData contact = new UserData(before.get(index).getId(),"Leha", "Grachev", "Lugansk");
        app.user().modify(index, contact);
        List<UserData> after = app.user().userList();

        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
