package ru.stqa.ptf.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.UserData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCase() throws Exception {
        app.goTo().gotoHomePage();
        List<UserData> before = app.user().userList();
        UserData contact = new UserData("Vasiliy", "Fedorov", "Rostov");
        app.user().create(contact);
        app.goTo().gotoHomePage();
        List<UserData> after = app.user().userList();

        Assert.assertEquals(after.size(), before.size() + 1);
        contact.setId(after.stream().max((Comparator.comparingInt(UserData::getId))).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
