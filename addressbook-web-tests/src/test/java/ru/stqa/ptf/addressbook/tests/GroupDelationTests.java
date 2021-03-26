package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.List;

public class GroupDelationTests extends TestBase {

    @Test
    public void testGroupDelation() throws Exception {
        app.getNavigationHelper().gotoGroupPege();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() - 1);


        before.remove(before.size()-1);
        Assert.assertEquals(after,before);


    }
}
