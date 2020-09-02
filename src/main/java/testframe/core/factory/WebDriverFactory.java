package testframe.core.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public WebDriver Build(WebDriverType type)
    {
        WebDriver driver;
        switch(type)
        {
            case Chrome:
                System.setProperty("webdriver.chrome.driver","C:/java/webdriver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                return driver;
            case Firefox:
                FirefoxOptions options = new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(options);
                return driver;
            default:
                throw new RuntimeException("unsupported wed driver \"" + type + "\" type!!!");
        }
    }

    public enum WebDriverType
    {
        Firefox, Chrome
    }
}
