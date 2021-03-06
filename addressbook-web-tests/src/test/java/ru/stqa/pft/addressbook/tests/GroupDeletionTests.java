package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }

  }


  @Test
  public void testGroupDeletion() throws Exception {

    app.goTo().GroupPage();
    Groups before = app.db().groups(); // список групп до удаления группы, взятый из базы данных
    GroupData deletedGroup = before.iterator().next(); // обращаемся к множеству через итератор и используем метод next чтобы вернуть первый попавшийся элемент множества
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups(); // список групп после удаления группы, взятый из базы данных
    assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListInUI();


  }

}