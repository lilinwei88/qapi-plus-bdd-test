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
    public HomePage login(String clientId, String username, String password) {
        fillTextField(getElement("clientId", LocatorType.NAME), clientId);
        fillTextField(getElement("userName", LocatorType.NAME), username);
        fillTextField(getElement("password", LocatorType.NAME), password);
        return (HomePage) new HomePage(driver).clickOnElement("loginClass", LocatorType.CLASS_NAME);
    }
}
