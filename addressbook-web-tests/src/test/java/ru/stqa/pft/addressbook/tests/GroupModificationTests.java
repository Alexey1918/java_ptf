package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test

  public void testGroupModification() {

    Groups before = app.db().groups(); // список групп из базы данных
    GroupData modifiedGroup = before.iterator().next(); // обращаемся к множеству через итератор и используем метод next чтобы вернуть первый попавшийся элемент множества

    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("test1")
            .withHeader("test2")
            .withFooter("test3");
    app.goTo().GroupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups(); // список групп из базы данных
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }
}
