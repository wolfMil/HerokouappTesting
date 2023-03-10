import org.testng.annotations.Test;
import pages.MainPage;

public class MainTest extends BaseTest {

@Test
    public void verifyContextMenuOpened() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.getContextMenu().click();

    }

}
