package testframe.elements.blocks;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;

public class Block extends ElementPrototype {

    public Block(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
    }

    public Block(ElementPrototype parent, By locator, String elementName, CoreAcolyteHelper coreData) {
        super(parent, locator, elementName, coreData);
    }
}
