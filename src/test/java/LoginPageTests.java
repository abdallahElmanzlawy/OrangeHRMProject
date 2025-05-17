import org.testng.annotations.Test;

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
    }
}
