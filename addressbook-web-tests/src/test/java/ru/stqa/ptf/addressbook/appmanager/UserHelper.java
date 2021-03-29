package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.UserData;
import ru.stqa.ptf.addressbook.model.Users;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void selectUserCheckbox() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void delationUser() {
        click(By.xpath("(//input[@value='Delete'])"));
    }

    public void modify(UserData user) {
        selectContactCheckboxById(user.getId());
        editUserCheckboxById(user.getId());
        fillUserForm(user);
        updateUser();
        returnToPage();
    }

    private void editUserCheckboxById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void initUserCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillUserForm(UserData userData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userData.getLastname());
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

    public void editUserCheckbox() {
        click(By.name("edit"));
    }

    public void selectContactCheckbox(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void updateUser() {
        click(By.xpath("//input[@name='update']"));
    }

    public void selectContactCheckboxById(int id) {
        wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
    }

    public boolean isThereAUser() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void create(UserData user) {
        initUserCreation();
        fillUserForm(user);
        submitUserCreation();
        returnToPage();
    }

    public void delete(UserData user) {
        selectContactCheckboxById(user.getId());
        delationUser();
        closeAlert();
        gotoHomePage();
    }

    /*public void delete(int index) {
        selectContactCheckbox(index);
        delationUser();
        closeAlert();
        gotoHomePage();
    }*/

    public void gotoHomePage() {
        click(By.linkText("home"));
    }


    public Users all() {

        Users users = new Users();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        elements.remove(0);

        for (WebElement element : elements) {

            List<WebElement> cells = element.findElements(By.tagName("td"));
            Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String home = cells.get(5).getText();



            users.add(new UserData()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastname)
                    .withHome(home));
        }
        return new Users(users);
    }


}







