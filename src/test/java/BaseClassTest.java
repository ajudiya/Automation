import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClassTest {
    protected WebDriver driver;
    protected String baseUrl = "https://automationexercise.com/";
    public JavascriptExecutor js;
    public SoftAssert sf;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
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
    public Object[][] getLogInData() {
        return new Object[][]{
                {"", "", false},
                {"jai.ajudiya@gmail.com", "Jay@1234", true},
                {"jay.ajudiya@gmail.com", "Jay@1234", false},
                {"jai.ajudiya@gmail.", "Jay@1234", false},
                {"jai.ajudiya@", "Jay@1234", false},
                {"@gmail.com", "Jay@1234", false}
        };
    }

    @DataProvider(name = "signUpData")
    public Object[][] getSignUpData() {
        return new Object[][]{
                {"", "" },
                {"Jay@1234", "jay.ajudiya@gmailcom"},
                {"Jay@1234", "jai.ajudiya@gmail."},
                {"Jay@1234", "jai.ajudiya@"},
                {"Jay@1234", "@gmail.com"},
                {"Jay", "jai.ajudiya@gmail.com"}
        };
    }

    @DataProvider(name="signUpDataSecondPage")
    public Object[][] getSignUpDataSecondPage(){
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"Test@1234","22","10","2000","Jay","Patel","TestTech","India","India","Gujarat", "Ahmedabad","132465","9998979695"});
        data.add(new Object[]{"Test@1234","15","5","2012","Jay@","Patel@","TestTechTestTechTestTech","IndiaIndiaIndia","IndiaIndiaIndia","GujaratIndiaIndia", "AhmedabadIndiaIndia","132465IndiaIndia","9998979695IndiaIndia"});
        data.add(new Object[]{"Test@1234@##@12345646","26","8","2019","Jay@#14654@","Patel@@#1321465","TestTechTestTechTestTech@#@#@#","IndiaIndiaIndia@#@#@","IndiaIndiaIndia@#@#@#","GujaratIndiaIndia@#@#@", "AhmedabadIndiaIndia@#@","132465IndiaIndia@#@#","9998979695@#$IndiaIndia"});
        return data.toArray(new Object[0][]);
    }

    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}