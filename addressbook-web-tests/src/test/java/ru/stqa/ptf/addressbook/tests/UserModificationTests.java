package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.UserData;

public class UserModificationTests extends TestBase{

    @Test
    public void testUserModification(){
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Elena", null, "892616601235"));
        }
        app.getUserHelper().selectUserCheckbox();
        app.getUserHelper().editUserCheckbox();
        app.getUserHelper().fillUserForm(new UserData("Elena", "Suvorova", "89263425678"));
        app.getUserHelper().updateUser();


    }
}
