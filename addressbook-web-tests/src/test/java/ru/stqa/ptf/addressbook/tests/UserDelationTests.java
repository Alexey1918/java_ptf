package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.UserData;

public class UserDelationTests extends TestBase{

    @Test
    public void testGroupDelation() throws Exception {
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Elena", null, "892616601235"));
        }
        app.getUserHelper().selectUserCheckbox();
        app.getUserHelper().delationUser();
        app.getUserHelper().closeAlert();

    }
}
