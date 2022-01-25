package com.qaipi.pages;


import com.qaipi.utils.LocatorType;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, String pageUrl) {
        super(driver, pageUrl);
    }

    /**
     * login with username and password.
     *
     * @param username user name
     * @param password password
     * @return home page
     */
    public HomePage login( String username, String password) {
//        fillTextField(getElement("clientId", LocatorType.ID), clientId);
        fillTextField(getElement("userName", LocatorType.ID), username);
        fillTextField(getElement("password", LocatorType.ID), password);
        return (HomePage) new HomePage(driver).clickOnElement("loginId", LocatorType.ID);
    }
}
