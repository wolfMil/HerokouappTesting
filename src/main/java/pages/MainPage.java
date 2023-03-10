package pages;

import org.openqa.selenium.WebDriver;

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

}
