package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    //Методы для UserDelationTests//
    public void selectUserCheckbox() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
        //wd.findElements(By.name("//table[@id='maintable']/tbody/tr[2]/td/input")).get(index).click();
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
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userData.getMiddlename());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(userData.getHome());
    }
    public void submitUserCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void returnToPage() { wd.findElement(By.linkText("home page")).click(); }
    //**********************************************//


    //Методы для editUser//
    public void editUserCheckbox(int index){
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void selectContactCheckbox(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }


    public void updateUser(){
        click(By.xpath("//input[@name='update']"));
    }

    public boolean isThereAUser() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void createUser(UserData user) {
        initUserCreation();
        fillUserForm(user);
        submitUserCreation();
        returnToPage();
    }

    public List<UserData> getUserList() {
        List<UserData> users = new ArrayList<UserData>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr"));//шарим по первой странице
        elements.remove(0);//удалили шапку
        for(WebElement element : elements){

            List<WebElement> cells = element.findElements(By.tagName("td"));//проваливаемся в контакт

            String firstName = cells.get(2).getText();//шарим в нутри контакта. имя
            String lastname = cells.get(1).getText();//Фамилия
            String home = cells.get(5).getText();//Адрес и что угодно
            Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));//забираем айди

            UserData contact = new UserData(id,firstName, lastname,home);//Cоздаем новый обьект
            users.add(contact);//Добавляем новые обьекты в лист который вызвали из теста
        }
        return users;



    }


    }



//".//[@id='maintable']/tbody/tr"
