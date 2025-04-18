import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Header;
import untilities.UserData;

public class ContactUsTest extends BaseTest {
    private Header header;
    private UserData userData;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        userData = new UserData();
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void contactUsTest() {
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setContactUsLink();
        Assert.assertTrue(contactUsPage.isGetInTouchText());
        contactUsPage.setNameField(userData.firstName);
        contactUsPage.setEmailField(userData.loginEmail);
        contactUsPage.setSubjectField("Subject");
        contactUsPage.setMessageField("Message");
        contactUsPage.setFileUpload(userData.file);
        contactUsPage.setSubmitButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(contactUsPage.isSubmittedMsg());
        contactUsPage.setHomeButton();
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
    }
}
