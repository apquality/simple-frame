package testframe.elements.simple;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;

public class Edit extends ElementPrototype {

    public Edit(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
    }

    public Edit(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(parent, locator, elementName, coreData);
    }

    public void fillText(String text) {
        fillElementText(text, text);
    }

    public void fillPassword(String text) {
        fillElementText(text, "**********");
    }

    private void fillElementText(String text, String logText) {
        logger.startFolder("Ввод текста '" + logText + "' в поле '" + elementName + "'");
        try {
            findElementObject();
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике поля ввода ", e);
        }
        logger.closeFolder();
    }

    public void checkText(String editText) {
        logger.startFolder("Проверка текста '" + editText + "' в кнопке [" + elementName + "]");
        try {
            findElementObject();
            if (!editText.equals(element.getText())) {
                logger.logErrorMessage("Ожидаемый -" + editText + "- текст отличается от текущего -" + element.getText() + "-");
            }
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике поля ввода ", e);
        }
        logger.closeFolder();
    }
}
