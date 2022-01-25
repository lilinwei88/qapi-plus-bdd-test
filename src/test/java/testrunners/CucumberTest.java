package testrunners;

import cucumber.api.CucumberOptions;

@CucumberOptions (
        plugin = {"pretty","json:target/cucumber-report/CucumberReport.json"},
        features = "classpath:features/general",
        glue = "stepdefinitions"
)
public class CucumberTest extends BaseTest {
}
