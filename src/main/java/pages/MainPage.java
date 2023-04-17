package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    //mapping elements

    public List<WebElement> listOfExamples() {
        return driver.findElements(By.tagName("li"));
    }

    public WebElement getContextMenu() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a"));
    }

    //actions with elements

    public void clickOnContextMenuBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']")));
    }

}
