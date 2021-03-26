package ru.stqa.ptf.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.UserData;
import java.util.HashSet;
import java.util.List;

public class UserDelationTests extends TestBase {

    @Test
    public void testGroupDelation() throws Exception {
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().createUser(new UserData("Elena", "Vincova", "Voronege"));
        }
        List<UserData> before = app.getUserHelper().getUserList();

        app.getUserHelper().selectContactCheckbox(before.size() - 1);
        app.getUserHelper().delationUser();
        app.getUserHelper().closeAlert();
        app.getNavigationHelper().gotoHomePage();

        List<UserData> after = app.getUserHelper().getUserList();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
