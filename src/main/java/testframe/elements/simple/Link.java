package testframe.elements.simple;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;

public class Link extends ElementPrototype {

    public Link(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
    }

    public Link(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(parent, locator, elementName, coreData);
    }

    public void click() {
        logger.startFolder("Клик на кнопке [" + elementName + "]");
        try {
            findElementObject();
            element.click();
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике кнопки", e);
        }
        logger.closeFolder();
    }

    public void checkText(String linkText) {
        logger.startFolder("Проверка текста '" + linkText + "' в ссылке '" + elementName + "'");
        try {
            findElementObject();
            if (!linkText.equals(element.getText())) {
                logger.logErrorMessage("Ожидаемый -" + linkText + "- текст отличается от текущего -" + element.getText() + "-");
            }
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике ссылки ", e);
        }
        logger.closeFolder();
    }
}
