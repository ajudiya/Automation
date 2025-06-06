import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://automationexercise.com/";
    public JavascriptExecutor js;
    public SoftAssert sf;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else {
//            throw new IllegalArgumentException("Browser not supported: " + browser);
//        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    @DataProvider(name = "logInData")
    public Object[][] getLogInData(){
        return new Object[][]{
                {"","",false},
                {"jai.ajudiya@gmail.com","Jay@1234",true},
                {"jay.ajudiya@gmail.com","Jay@1234",false},
                {"jai.ajudiya@gmail.","Jay@1234",false},
                {"jai.ajudiya@","Jay@1234",false},
                {"@gmail.com","Jay@1234",false}
        };
    }
    @AfterMethod
    public void cleanUp()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}