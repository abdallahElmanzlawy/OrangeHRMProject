import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseTest {

    @Test
    public void testSuccessLogin()
    {
        //EnterUserName
        loginPage.setUserNameField("Admin");
        //EnterPassword
        loginPage.setPasswordField("admin123");
        //ClickButton
        loginPage.clickLoginButton();

        //Assertion
        assertEquals(loginPage.getResult(),"Dashboard","Failed");
    }
}
