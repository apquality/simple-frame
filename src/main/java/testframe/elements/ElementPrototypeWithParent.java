package testframe.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;

public abstract class ElementPrototypeWithParent extends ElementPrototype {
    protected ElementPrototypeWithParent parent;

    public ElementPrototypeWithParent(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
        this.parent = null;
    }

    public ElementPrototypeWithParent(ElementPrototypeWithParent parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
        this.parent = parent;
    }

    protected void findElementObject() {
        if (parent != null) {
            logger.logDebugMessage("Поиск элемента на основании родительского");
            element = parent.element.findElement(locator);

        } else {
            logger.logDebugMessage("Прямой поиск элемента");
            element = driver.findElement(locator);
        }
    }

    public void waitAppear(int seconds) {
        logger.startFolder("Ожидние появления элемента " + elementName + " в течении " + seconds + " секунд");
        //TODO: а оно надо? разве что для единообразия, в целом checkPresent() даёт ровно то же самое
        String fullXPath = getFullElementXpath();
        logger.closeFolder();
        Assert.fail("не реализовано и не очень понятно надо ли");
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
        return super.getCleanXpath(fullXpath);
    }
}
