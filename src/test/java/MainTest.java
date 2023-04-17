import org.openqa.selenium.Alert;
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
        Assert.assertEquals(mainMenu.size(), 44);

    }

    @Test
    public void verifyContextMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.clickOnContextMenu();
        mainPage.clickOnContextMenuBox();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.dismiss();

    }

    @Test
    public void verifyDropDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.clickOnDropDownExample();
        mainPage.clickOnDropdownMenu();
        mainPage.assertDropDownOption("Option 2", "Option 2");



    }

}
