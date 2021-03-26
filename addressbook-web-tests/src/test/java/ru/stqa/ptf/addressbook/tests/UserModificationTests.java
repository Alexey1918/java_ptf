package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTests extends TestBase{

    @Test
    public void testUserModification() {
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().createUser(new UserData("Elena", null, "892616601235"));
        }

        List<UserData> before = app.getUserHelper().getUserList(); // список контактов до изменения контакта

        app.getUserHelper().selectContactCheckbox(before.size() - 1);
        //app.getUserHelper().selectUserCheckbox();
        app.getUserHelper().editUserCheckbox(before.size() - 1);
        UserData contact = new UserData(before.get(before.size()-1).getId(),"Leha", "Grachev", "Lugansk");
        app.getUserHelper().fillUserForm(contact);
        app.getUserHelper().updateUser();
        app.getUserHelper().returnToPage();

        List<UserData> after = app.getUserHelper().getUserList();
        
       Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));




    }
}
