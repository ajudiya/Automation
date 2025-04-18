import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Footer;
import pages.Header;
import untilities.UserData;

public class FooterSubscriptionTest extends BaseTest{
    private Footer footer;
    private Header header;
    private UserData userData;
    @BeforeMethod
    public void inIt(){
        footer = new Footer(driver);
        header = new Header(driver);
        js = (JavascriptExecutor) driver;
        userData = new UserData();
    }
    @Test
    public void subscriptionEmailTest(){
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(footer.isSubscriptionText());
        footer.setSubscriptionEmailField(userData.subscriptionEmail);
        footer.setSubscriptionButton();
        Assert.assertTrue(footer.isSuccessMsg());
    }
}
