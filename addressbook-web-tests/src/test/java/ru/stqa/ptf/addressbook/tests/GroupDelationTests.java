package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;

public class GroupDelationTests extends TestBase {

    @Test
    public void testGroupDelation() throws Exception {
        app.getNavigationHelper().gotoGroupPege();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returntoGroupPage();
    }
}
