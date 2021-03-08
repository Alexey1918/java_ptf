package ru.stqa.ptf.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDelationTests extends TestBase{

    @Test
    public void testGroupDelation() throws Exception {
        gotoGroupPege();
        selectGroup();
        deleteGroup();
        returntoGroupPage();
    }
}
