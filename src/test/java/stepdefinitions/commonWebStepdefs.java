package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class commonWebStepdefs {
    protected static WebDriver driver;
    private static Logger logger = LogManager.getRootLogger();

    protected static ChromeDriverService chService;
    protected static void startService() {
        if (null == chService) {
            try {
                WebDriverManager.chromedriver().setup();
                chService = new ChromeDriverService.Builder().
                        usingDriverExecutable(new File(WebDriverManager.chromedriver().getBinaryPath())).
                        usingAnyFreePort().
                        build();
                chService.start();
            } catch (Exception e) {
                logger.error("chrome service is not start: ", e);
            }
        }
    }
}
