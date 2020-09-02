package testframe.elements.simple;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;

public class Label extends ElementPrototype {

    public Label(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
    }

    public Label(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(parent, locator, elementName, coreData);
    }

    public void checkText(String labelText) {
        logger.startFolder("Проверка текста '" + labelText + "' в заголовке '" + elementName + "'");
        try {
            findElementObject();
            if (!labelText.equals(element.getText())) {
                logger.logErrorMessage("Ожидаемый -" + labelText + "- текст отличается от текущего -" + element.getText() + "-");
            }
        } catch (Exception e) {
            logger.logCriticalError("Критическая ошибка в логике заголовке ", e);
        }
        logger.closeFolder();
    }
}
