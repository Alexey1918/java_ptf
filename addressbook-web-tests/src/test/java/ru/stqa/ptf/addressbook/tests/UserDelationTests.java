package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.UserData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDelationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().gotoHomePage();
        if (app.user().all().size()==0) {
            app.user().create(new UserData().withFirstName("Lena"));
        }
    }

    @Test
    public void testGroupDelation() throws Exception {

        Set<UserData> before = app.user().all();
        UserData deleteUser = before.iterator().next();
        app.user().delete(deleteUser);
        Set<UserData> after = app.user().all();

        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(deleteUser);
        Assert.assertEquals(after,before);
    }
}
