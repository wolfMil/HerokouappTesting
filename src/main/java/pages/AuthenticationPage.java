package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AuthenticationPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    //maping elements #################################################################

    public WebElement formAuthenticationExample() {
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }

    public WebElement usrInputForm() {
        return driver.findElement(By.xpath("//input[@id='username']"));
    }
    public WebElement passInputForm() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }


    //actions with elements ###########################################################

    public void assertBasicAuthentication(String username, String password) {       //passing credentials in the url
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        this.driver.manage().window().maximize();

        String confirmation = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(confirmation, "Congratulations! You must have the proper credentials.");
    }

    public void assertFormAuthentication(String username, String password) {
        formAuthenticationExample().click();
        usrInputForm().sendKeys(username);
        passInputForm().sendKeys(password);
        loginButton().click();
        String confirmation = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        Assert.assertEquals(confirmation, "Welcome to the Secure Area. When you are done click logout below.");
    }

}
