package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.time.Duration;

public class ApplicationManager {

  WebDriver wd;

  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private  GroupHelper groupHelper ;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();

    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();

    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }



    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    wd.get("http://localhost/addressbook/birthdays.php");
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    sessionHelper.doLogout();
    wd.quit();
  }


  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }
}