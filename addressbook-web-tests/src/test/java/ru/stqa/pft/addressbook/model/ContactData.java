package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private  String firstName;
  @Expose
  private  String lastName;
  @Expose
  private  String phoneNumber;
  @Expose
  private  String email;
  @Expose
  private  String groupName;
  private  String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String allEmails;
  private String email1;
  private String email2;
  private String email3;
  private String editAddress;
  private String mainAddress;
  @Expose
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getMainAddress() {
    return mainAddress;
  }

  public ContactData withMainAddress(String mainAddress) {
    this.mainAddress = mainAddress;
    return this;
  }


  public String getEditAddress() {
    return editAddress;
  }

  public ContactData withEditAddress(String editAddress) {
    this.editAddress = editAddress;
    return this;
  }

  public String getEmail1() {
    return email1;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public ContactData withFirstName(String first_name) {
    this.firstName = first_name;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public ContactData withLastName(String last_name) {
    this.lastName = last_name;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public ContactData withPhone_number(String phone_number) {
    this.phoneNumber = phone_number;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getGroupName() {
    return groupName;
 }

  public ContactData withGroup_name(String group_name) {
    this.groupName = group_name;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", first_name='" + firstName + '\'' +
            ", last_name='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

}
