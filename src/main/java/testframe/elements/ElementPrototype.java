package testframe.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.core.modules.LoggerPrototype;

import java.util.concurrent.TimeUnit;

public abstract class ElementPrototype {
    protected WebElement element;
    protected By locator;
    protected String elementName;
    protected WebDriver driver;
    protected LoggerPrototype logger;
    protected int waitTime;
    protected ElementPrototype parent;

    public ElementPrototype(By locator, String elementName, CoreAcolyteHelper coreData) {
        this.driver = coreData.driver;
        this.logger = coreData.logger;
        this.locator = locator;
        this.elementName = elementName;
        this.waitTime = coreData.settings.elementWaitTimeout;
        this.parent = null;
    }

    public ElementPrototype(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        this.driver = coreData.driver;
        this.logger = coreData.logger;
        this.locator = locator;
        this.elementName = elementName;
        this.waitTime = coreData.settings.elementWaitTimeout;
        this.parent = parent;
    }

    protected void findElementObject() {
        logger.logDebugMessage("Основной поиск элемента");
        element = driver.findElement(locator);
    }

    public void checkPresent() {
        logger.startFolder("Проверка наличия элемента -" + elementName + "-");
        try {
            findElementObject();
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике элемента ", e);
        }
        logger.closeFolder();
    }

    public void checkAbsent() {
        logger.startFolder("Проверка отсутствия элемента -" + elementName + "-");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            findElementObject();
            logger.logErrorMessage("Элемент -" + elementName + "- присутствует");
        } catch (Error e) {
        }
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        logger.closeFolder();
    }

    public void click() {
        logger.startFolder("Клик по элементу -" + elementName + "-");
        findElementObject();
        element.click();
        logger.closeFolder();
    }

    public void waitAppear(int seconds) {
        logger.startFolder("Ожидние появления элемента " + elementName + " в течении " + seconds + " секунд");
        String fullXPath = getFullElementXpath();
        logger.closeFolder();
    }

    public void waitDisappear(int seconds) {
        logger.startFolder("Ожидние исчезновения элемента " + elementName + " в течении " + seconds + " секунд");
        String fullXPath = getFullElementXpath();
        logger.closeFolder();
    }

    protected String getFullElementXpath() {
        if (parent == null) {
            return getCleanXpath(locator.toString());//((By.ByXPath) locator).xpathExpression;
        } else {
            return parent.getFullElementXpath() + getCleanXpath(locator.toString());
        }
    }

    protected String getCleanXpath(String fullXpath) {
        if (fullXpath.startsWith("By.xpath: ")) {
            return fullXpath.substring(10);//---//div[@class='login-block']By.xpath: /div[@class='submit']
        }
        logger.logErrorMessage("Неправильный xpath -" + fullXpath + "-");
        return "---";
    }
}
