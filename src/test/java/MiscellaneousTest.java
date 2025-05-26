import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Footer;
import pages.Header;

public class MiscellaneousTest extends BaseTest {
    private Header header;
    private Footer footer;

    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        footer = new Footer(driver);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void scrollingWithArrowButton(){
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(footer.isSubscriptionText());
        footer.setScrollUpButton();
    }
}
