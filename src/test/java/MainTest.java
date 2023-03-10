import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MainPage;

public class MainTest extends BaseTest {

    public void OpenMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();


    }

}
