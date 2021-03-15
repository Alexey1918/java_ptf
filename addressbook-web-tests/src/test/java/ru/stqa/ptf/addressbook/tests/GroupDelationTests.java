package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupDelationTests extends TestBase {

    @Test
    public void testGroupDelation() throws Exception {
        app.getNavigationHelper().gotoGroupPege();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returntoGroupPage();
    }
}
