
package ru.stqa.ptf.addressbook.model;
import ru.stqa.ptf.addressbook.tests.TestBase;
import java.util.Objects;

public class UserData extends TestBase {
    private int id;
    private  String firstname;
    private  String lastname;
    private  String home;


    public UserData(String firstname, String lastname, String home) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.home = home;

    }

    public UserData(int id, String firstname, String lastname, String home) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.home = home;
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id && Objects.equals(firstname, userData.firstname) && Objects.equals(lastname, userData.lastname) && Objects.equals(home, userData.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }



}

