package ru.stqa.ptf.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{


    @Test
    public void testGroupCreation() throws Exception {
        gotoGroupPege();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returntoGroupPage();
        wd.findElement(By.linkText("Logout")).click();
    }

}
