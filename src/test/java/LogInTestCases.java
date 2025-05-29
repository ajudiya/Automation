import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.SignUpLogInPage;
import untilities.UserData;

public class LogInTestCases extends BaseClassTest{
    private Header header;
    private SignUpLogInPage signUpLogInPage;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
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
    }
}
