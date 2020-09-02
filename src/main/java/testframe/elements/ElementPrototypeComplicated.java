package testframe.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.core.modules.LoggerPrototype;

public abstract class ElementPrototypeComplicated extends ElementPrototype {

    public ElementPrototypeComplicated(WebElement element, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
        this.element = element;
    }

    /*
    public ElementPrototypeComplicated(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
    }
    */

    protected void findElementObject() {
        //TODO: а оно вообще надо?
        //в данном случае поиск элемента вообще не шибко подразумевается, он должен инициироваться извне
    }
}
