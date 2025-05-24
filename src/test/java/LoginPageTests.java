import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {

    @Test
    public void testSuccessLogin()
    {
        //EnterValidUserName
        loginPage.setUserNameField("Admin");
        //EnterValidPassword
        loginPage.setPasswordField("admin123");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertEquals(loginPage.getSuccessResult(),"Dashboard","Failed Login");
    }

    @Test
    public void testInvalidUsername()
    {
        //EnterInvalidUserName
        loginPage.setUserNameField("Ad");
        //EnterValidPassword
        loginPage.setPasswordField("admin123");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertTrue(loginPage.isInvalidErrorMessageVisible(),"Incorrect Results");
    }

    @Test
    public void testInvalidPassword()
    {
        //EnterInvalidUserName
        loginPage.setUserNameField("Admin");
        //EnterValidPassword
        loginPage.setPasswordField("admin");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertTrue(loginPage.isInvalidErrorMessageVisible(),"Incorrect Results");
    }

    @Test
    public void testEmptyPassword()
    {
        //EnterInvalidUserName
        loginPage.setUserNameField("Admin");
        //EnterValidPassword
        loginPage.setPasswordField("");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertTrue(loginPage.isRequiredErrorMessageVisible(),"Incorrect Results");
    }

    @Test
    public void testEmptyEmail()
    {
        //EnterInvalidUserName
        loginPage.setUserNameField("");
        //EnterValidPassword
        loginPage.setPasswordField("admin123");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertTrue(loginPage.isRequiredErrorMessageVisible(),"Incorrect Results");
    }

    @Test
    public void testEmptyEmailAndPassword()
    {
        //EnterInvalidUserName
        loginPage.setUserNameField("");
        //EnterValidPassword
        loginPage.setPasswordField("");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertTrue(loginPage.isDuplicatedRequiredErrorMessageVisible());
    }
}
