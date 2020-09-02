package testframe.elements.simple;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;

public class Button extends ElementPrototype {
    protected ElementPrototype parent;

    public Button(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
        this.parent = parent;
    }

    public Button(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
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

    public void checkText(String buttonText) {
        logger.startFolder("Проверка текста '" + buttonText + "' в кнопке [" + elementName + "]");
        try {
            findElementObject();
            if (!buttonText.equals(element.getText())) {
                logger.logErrorMessage("Ожидаемый -" + buttonText + "- текст отличается от текущего -" + element.getText() + "-");
            }
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике кнопки ", e);
        }
        logger.closeFolder();
    }
}
