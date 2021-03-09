package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class UserDelationTests extends TestBase{

    @Test
    public void testGroupDelation() throws Exception {
        app.getUserHelper().selectUserCheckbox();
        app.getUserHelper().delationUser();
        app.getUserHelper().closeAlert();

    }
}
