package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    //locatedElements
    private final By userNameField = By.cssSelector("input[name='username']");
    private final By passwordField = By.cssSelector("input[name='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By verifySuccessResult = By.xpath("//h6[contains(.,'Dashboard')]");
    private final By verifyInvalidResult = By.xpath("//p[contains(., 'Invalid')]");
    private final By requiredErrorMessage = By.cssSelector(".oxd-input-field-error-message");

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

    public String getSuccessResult()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifySuccessResult));
        return driver.findElement(verifySuccessResult).getText();
    }


//    public String getInvalidResult()
//    {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyInvalidResult));
//        return driver.findElement(verifyInvalidResult).getText();
//    }

    public boolean isInvalidErrorMessageVisible()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyInvalidResult));
        return driver.findElement(verifyInvalidResult).isDisplayed();
    }

    public boolean isRequiredErrorMessageVisible()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        return driver.findElement(requiredErrorMessage).isDisplayed();
    }

    public boolean isDuplicatedRequiredErrorMessageVisible()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        List<WebElement> requiredErrorList = driver.findElements(requiredErrorMessage);
        for (int i = 0 ; i < requiredErrorList.size() ; i++)
        {
            if ( !requiredErrorList.get(i).isDisplayed())
            {
                return false;
            }
        }
        return true;
    }

}
