package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        this.driver = driver;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        this.driver.get("https://the-internet.herokuapp.com/");
        this.driver.manage().window().maximize();
    }

    //mapping elements #################################################################################################

    public List<WebElement> listOfExamples() {
        return driver.findElements(By.tagName("li"));
    }

    public WebElement getContextMenu() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a"));
    }

    public WebElement getDropDownExample() {
        return driver.findElement(By.xpath("//a[@href='/dropdown']"));
    }

    public WebElement getDropDownMenu() {
        return driver.findElement(By.xpath("//select[@id='dropdown']"));
    }

    public List<WebElement> getDropDownList() {
        WebElement webElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        return webElement.findElements(By.tagName("option"));
    }

    //actions with elements ############################################################################################

    public void clickOnContextMenu() {
        getContextMenu().click();
    }
    public void clickOnContextMenuBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']"))).perform();
    }

    public void clickOnDropDownExample() {
        getDropDownExample().click();
    }
    public void clickOnDropdownMenu() {
        getDropDownMenu().click();
    }

    public void selectDropDownOption(String option) {

        for (WebElement e : getDropDownList()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            if (e.getText().equals(option)) {
                e.click();
            }
        }
    }
    public void assertDropDownOption(String chosenOption, String expectedOption) {
        for (WebElement e : getDropDownList()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            if (e.getText().equals(chosenOption)) {
                e.click();
                chosenOption = e.getText();
            }
        }
        Assert.assertEquals(chosenOption, expectedOption, "Something's wrong, values mismatch!");
    }

}
