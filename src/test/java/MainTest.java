import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TablePage;

import java.util.HashMap;
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
    @Test
    public void verifyInfiniteScroll() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.clickOnInfiniteScrollExample();
        mainPage.assertInfiniteScrollDown();

    }

    @Test
    public void verifySortableDataTables() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        TablePage tablePage = new TablePage(driver);
        tablePage.clickOnTablesExample();

        List<HashMap<String, String>> tableMap = tablePage.getTableData();
        System.out.println(tablePage.getCellData("First Name", 1));
        System.out.println(tablePage.getCellData("First Name", 3));
        System.out.println(tablePage.getCellData("Email", 3));

    }

}
