package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.UserData;
import java.util.HashSet;
import java.util.List;

public class UserDelationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().gotoHomePage();
        if (app.user().userList().size()==0) {
            app.user().create(new UserData("Elena", null, "892616601235"));
        }
    }

    @Test
    public void testGroupDelation() throws Exception {

        List<UserData> before = app.user().userList();
        int index = before.size()-1;
        app.user().delete(index);

        List<UserData> after = app.user().userList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
