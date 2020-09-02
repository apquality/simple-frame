package testframe.core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import testframe.core.factory.WebDriverFactory;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.core.modules.DriverHelper;
import testframe.core.modules.LoggerConsole;
import testframe.core.modules.LoggerPrototype;

public class TestCore {
    protected WebDriver driver;
    protected LoggerPrototype logger;
    protected CoreSettings settings;
    protected DriverHelper driverHelper;
    protected CoreAcolyteHelper coreData;

    @Before
    public void SetupTest()
    {
        driver = new WebDriverFactory().Build(WebDriverFactory.WebDriverType.Chrome);
        logger = new LoggerConsole();
        settings = new CoreSettings();
        coreData = new CoreAcolyteHelper(driver, logger, settings);
        //driver.get("https://yandex.ru/");
    }


    @After
    public void TeardownTest()
    {
        try {
            driver.quit();
        }
        catch (Exception e) {
            // Ignore errors if unable to close the browser
        }
    }
}
