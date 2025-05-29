import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.SignUpLogInPage;
import untilities.UserData;

public class LoginUserTest extends BaseTest {
    private Header header;
    private UserData userData;
    private SignUpLogInPage signUpLogInPage;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        userData = new UserData();
        signUpLogInPage = new SignUpLogInPage(driver);
    }

    @Test(priority = 1)
    public void loginUserWithValidTest() {
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
        signUpLogInPage.setLoginEmailField(userData.loginEmail);
        signUpLogInPage.setLoginPasswordField(userData.loginPassword);
        signUpLogInPage.setLoginButton();
        Assert.assertTrue(header.isUsernameLoggedInText());
        header.setLogoutButton();
    }

    @Test(priority = 2)
    public void loginUserWithInValidEmailTest() {
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
        signUpLogInPage.setLoginEmailField(userData.inValidLoginEmail);
        signUpLogInPage.setLoginPasswordField(userData.loginPassword);
        signUpLogInPage.setLoginButton();
        Assert.assertTrue(signUpLogInPage.isInvalidEmailPassMag());
    }
    @Test(priority = 3)
    public void logOutTest() {
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
        signUpLogInPage.setLoginEmailField(userData.loginEmail);
        signUpLogInPage.setLoginPasswordField(userData.loginPassword);
        signUpLogInPage.setLoginButton();
        Assert.assertTrue(header.isUsernameLoggedInText());
        header.setLogoutButton();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
    }
    @Test(dataProvider = "logInData")
    public void logInTestCases(String email, String password, boolean isValid){
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
        signUpLogInPage.logInEmailFieldClear();
        signUpLogInPage.setLoginEmailField(email);
        signUpLogInPage.logInPasswordClear();
        signUpLogInPage.setLoginPasswordField(password);
        signUpLogInPage.setLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/", "Login failed with valid credentials");
    }
}
