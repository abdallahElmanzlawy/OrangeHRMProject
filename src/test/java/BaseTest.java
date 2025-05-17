import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void SetUp()
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

//    public void tearDown()
//    {
//        driver.quit();
//    }
}
