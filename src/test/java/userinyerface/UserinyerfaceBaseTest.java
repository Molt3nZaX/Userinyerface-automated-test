package userinyerface;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class UserinyerfaceBaseTest {
    @BeforeMethod
    public void setUp() {
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        ISettingsFile configFile = new JsonSettingsFile("config.json");
        browser.goTo(String.valueOf(configFile.getValue("/baseUrl")));
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void tearDown() {
        Browser browser = AqualityServices.getBrowser();
        browser.quit();
    }
}