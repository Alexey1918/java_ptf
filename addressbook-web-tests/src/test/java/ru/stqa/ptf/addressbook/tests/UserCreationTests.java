package ru.stqa.ptf.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {


    @Test
    public void testUserCase() throws Exception {
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().initUserCreation();
        UserData contact = new UserData("Vasiliy", "Fedorov", "Rostov");
        app.getUserHelper().fillUserForm(contact);
        app.getUserHelper().submitUserCreation();
        app.getUserHelper().returnToPage();
        List<UserData> after = app.getUserHelper().getUserList();


        Assert.assertEquals(after.size(), before.size() + 1);
        after.remove(after.size()-1);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
