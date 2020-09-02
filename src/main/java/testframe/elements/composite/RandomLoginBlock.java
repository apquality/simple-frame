package testframe.elements.composite;

import org.openqa.selenium.By;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.ElementPrototype;
import testframe.elements.simple.Edit;
import testframe.elements.simple.Link;

public class RandomLoginBlock extends ElementPrototype {
    public Edit userName;
    public Edit password;
    public Link loginButton;
    public Link cancelButton;
    protected ElementPrototype parent;

    public RandomLoginBlock(By locator, String elementName, CoreAcolyteHelper coreData) {
        super(locator, elementName, coreData);
        userName = new Edit(this, By.xpath("/div[@class='name']/input"), "Поле логина", coreData);
        password = new Edit(this, By.xpath("/div[@class='password']/input"), "Поле пароля", coreData);
        loginButton = new Link(this, By.xpath("/div[@class='submit']"), "Войти", coreData);
        cancelButton = new Link(this, By.xpath("/div[@class='cancel']"), "Отмена", coreData);
    }
}
