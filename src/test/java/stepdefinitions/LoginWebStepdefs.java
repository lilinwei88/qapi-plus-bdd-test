package stepdefinitions;

import com.qaipi.pages.HomePage;
import com.qaipi.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static com.qaipi.init.PropertiesManager.loadProp;

public class LoginWebStepdefs extends commonWebStepdefs {
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void beforeScenario()
    {
        startService();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(chService, options);
    }

    @Given("^I am on the Login Page$")
    public void qaEnvironmentIsUp() {
        loginPage = new LoginPage(driver, loadProp("baseUrl"));
    }

    @When("^\"([^\"]*)\" login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginWithClientNameAndUserIdWithPassword(String clientId, String userId, String password) {
        homePage = loginPage.login(clientId, userId,password);
    }

    @Then("^I should see homepage$")
    public void iShouldSeeHomepage() {
        Assert.assertTrue(homePage.confirmElementsOnHomePage("textXpath", "Hi"));
        homePage.logout();
    }

    @Then("^I should not see homepage$")
    public void iShouldNotSeeHomepage() {
        Assert.assertFalse(homePage.confirmElementsOnHomePage("textXpath", "Hi"));
        homePage.logout();
    }

    @When("^\"([^\"]*)\" admin login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void adminLoginWithUserIdAndPassword(String clientId, String userId, String password) {
        homePage = loginPage.login(clientId, userId,password);
        homePage.logout();
    }

    @Then("^I should see admin page$")
    public void iShouldSeeAdminPage() {
        Assert.assertTrue(homePage.confirmElementsOnHomePage("textXpath", "Admin"));
        homePage.logout();
    }

    @Then("^I should not see admin page$")
    public void iShouldNotSeeAdminPage() {
        Assert.assertFalse(homePage.confirmElementsOnHomePage("textXpath", "Admin"));
        homePage.logout();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
