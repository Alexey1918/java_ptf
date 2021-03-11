
package ru.stqa.ptf.addressbook.model;

import ru.stqa.ptf.addressbook.tests.TestBase;

public class UserData extends TestBase {
    private final String firstname;
    private final String middlename;
    private final String home;


    public UserData(String firstname, String middlename, String home) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.home = home;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getHome() {
        return home;
    }
}

