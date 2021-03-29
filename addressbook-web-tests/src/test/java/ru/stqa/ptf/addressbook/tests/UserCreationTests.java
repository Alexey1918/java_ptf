package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.UserData;
import ru.stqa.ptf.addressbook.model.Users;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCase() throws Exception {
        app.goTo().gotoHomePage();
        Users before = app.user().all();
        UserData user = new UserData().withFirstName("Vasiliy").withLastName("Ivanov").withHome("Lipetsk");
        app.user().create(user);
        app.goTo().gotoHomePage();
        Users after = app.user().all();

        assertThat(after.size(),equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
