import org.junit.Test;
import pages.simple.LoginPage;
import testframe.core.TestCore;

public class RandomTest extends TestCore {
    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(coreData);
        logger.enableDebugMessages();
        loginPage.header.checkText("Добро пожаловать");
        loginPage.auth("user", "password");
        loginPage.loginBlock.loginButton.waitDisappear(5);
    }
}
