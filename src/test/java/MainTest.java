import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class MainTest extends BaseTest {

@Test
    public void verifyMainMenuOpened() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        List<WebElement> mainMenu = mainPage.listOfExamples();
        for ( WebElement e : mainMenu) {
            System.out.println(e.getText());
        }
        Assert.assertEquals(mainMenu.size(), 44, "Not verified that main menu is opened correctly.");

    }

@Test
    public void verifyContextMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.getContextMenu().click();
        mainPage.clickOnContextMenuBox();


    }

}
