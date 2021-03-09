package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.addressbook.model.UserData;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    //Методы для UserDelationTests//
    public void selectUserCheckbox() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td/input"));
    }
    public void delationUser() {
        click(By.xpath("(//input[@value='Delete'])"));
    }
    public void closeAlert() {
        wd.switchTo().alert().accept();
    }
    //*******************************//




    //Методы для CreateUser//
    public void initUserCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillUserForm(UserData userData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userData.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(userData.getMiddlename());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(userData.getHome());
    }

    public void submitUserCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void returnToPage() {
        wd.findElement(By.linkText("home page")).click();
    }
    //**********************************************//







}
