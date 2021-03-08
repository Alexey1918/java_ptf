package ru.stqa.ptf.addressbook;

import org.testng.annotations.*;

public class UserTestCase extends TestBase{

    @Test
    public void testUserCase() throws Exception {
        initUserCreation();
        fillUserForm(new UserData("Alex", "Vinnov", "892616601235"));
        submitUserCreation();
        returnToPage();
    }
}
