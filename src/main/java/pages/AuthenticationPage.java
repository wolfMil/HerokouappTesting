package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    //actions with elements ###########################################################

    public void assertBasicAuthentication(String username, String password) {       //passing credentials in the url
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(url);

        String confirmation = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(confirmation, "Congratulations! You must have the proper credentials.");

    }

}
