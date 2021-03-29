
package ru.stqa.ptf.addressbook.model;
import ru.stqa.ptf.addressbook.tests.TestBase;
import java.util.Objects;

public class UserData extends TestBase {
    private  int id = Integer.MAX_VALUE;
    private  String firstname;
    private  String lastname;
    private  String home;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id && Objects.equals(firstname, userData.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public UserData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserData withHome(String home) {
        this.home = home;
        return this;
    }

    public UserData withId(int id) {
        this.id = id;return this;
    }



    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHome() {
        return home;
    }


}

