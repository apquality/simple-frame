package testframe.core.helpers;

import org.openqa.selenium.WebDriver;
import testframe.core.CoreSettings;
import testframe.core.modules.LoggerPrototype;

public class CoreAcolyteHelper {
    public WebDriver driver;
    public LoggerPrototype logger;
    public CoreSettings settings;

    public CoreAcolyteHelper(WebDriver driver, LoggerPrototype logger, CoreSettings settings) {
        this.driver = driver;
        this.logger = logger;
        this.settings = settings;
    }
}
