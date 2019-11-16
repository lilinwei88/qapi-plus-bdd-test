package com.qaipi.pages;

import com.qaipi.utils.LocatorType;
import org.openqa.selenium.WebDriver;

import static com.qaipi.init.PropertiesManager.loadProp;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * verify element on home page.
     *
     * @param locator locator to be verified
     * @return true if the element exist
     */
    public Boolean confirmElementsOnHomePage(String locator, String text) {
//        changeDefaultWait(10);
        boolean exist =  doesElementExist(locator, text, LocatorType.XPATH);
//        resetDefaultWait();
        return exist;
    }

    /**
     * log out of the site.
     *
     * @return HomePage
     */
    public void logout() {
//        clickOnElement("profilePictureId", LocatorType.ID);
//        clickOnElement("logoutLink", LocatorType.LINK_TEXT);
        this.navigateToURL(loadProp("baseUrl")+"/Account/Logout");
    }
}
