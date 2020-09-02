package pages.simple;

import org.openqa.selenium.By;
import pages.PagePrototype;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.simple.Label;

public class MainPage extends PagePrototype {
    public Label header;

    public MainPage(CoreAcolyteHelper coreData) {
        super(coreData);
        header = new Label(By.xpath("//div[@class='header']/div[@class='title']"), "Заголовок", coreData);
    }
}
