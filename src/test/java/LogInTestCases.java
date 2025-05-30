import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.SignUpLogInPage;

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
    @Test(dataProvider = "signUpData")
    public void signUpTestCases(String name, String email){
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        signUpLogInPage.signUpNameFieldClear();
        signUpLogInPage.setSignUpNameField(name);
        signUpLogInPage.signUpEmailFieldClear();
        signUpLogInPage.setSignUpEmailField(email);
        signUpLogInPage.setSignUpButton();
    }
}