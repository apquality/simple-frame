package pages.simple;

import org.openqa.selenium.By;
import pages.PagePrototype;
import testframe.core.helpers.CoreAcolyteHelper;
import testframe.elements.composite.RandomLoginBlock;
import testframe.elements.simple.Label;

public class LoginPage extends PagePrototype {
    public Label header;
    public RandomLoginBlock loginBlock;

    public LoginPage(CoreAcolyteHelper coreData) {
        super(coreData);
        header = new Label(By.xpath("//div[@class='header']/h1"), "Заголовок", coreData);
        loginBlock = new RandomLoginBlock(By.xpath("//div[@class='login-block']"), "блок логина", coreData);
    }

    public void auth(String login, String password) {
        logger.startFolder("Вход под " + login);
        loginBlock.userName.fillText(login);
        loginBlock.password.fillPassword(password);
        loginBlock.loginButton.click();
        logger.closeFolder();
    }
}
