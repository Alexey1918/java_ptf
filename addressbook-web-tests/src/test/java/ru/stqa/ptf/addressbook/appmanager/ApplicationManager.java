package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.ptf.addressbook.model.UserData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private  NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private  GroupHelper groupHelper ;
    private  UserHelper userHelper ;

    public void init() {
        String browser = BrowserType.CHROME;
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.IE)){
            wd = new ChromeDriver();
        }
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        userHelper = new UserHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public UserHelper getUserHelper() { return userHelper; }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


}
