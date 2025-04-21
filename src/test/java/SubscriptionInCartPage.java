import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Footer;
import pages.Header;
import untilities.UserData;

public class SubscriptionInCartPage extends BaseTest{
    private Header header;
    private Footer footer;
    private UserData userData;
    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        footer = new Footer(driver);
        userData = new UserData();
    }
    @Test
    public void subscriptionCartTest(){
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setCartLink();
        footer.setSubscriptionEmailField(userData.subscriptionEmail);
        footer.setSubscriptionButton();
        Assert.assertTrue(footer.isSuccessMsg());
    }
}
