package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //locatedElements
    By userNameField = By.cssSelector("input[name='username']");
    By passwordField = By.cssSelector("input[name='password']");
    By loginButton = By.cssSelector("button[type='submit']");
    By verifyResult = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //methods

    public void setUserNameField(String userName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setPasswordField(String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public String getResult()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyResult));
        return driver.findElement(verifyResult).getText();
    }

}
