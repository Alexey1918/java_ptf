package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCase() throws Exception {
        app.initUserCreation();
        app.fillUserForm(new UserData("Alex", "Vinnov", "892616601235"));
        app.submitUserCreation();
        app.returnToPage();
    }
}
