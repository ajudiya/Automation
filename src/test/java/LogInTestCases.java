import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.SignUpLogInPage;
import untilities.UserData;

public class LogInTestCases extends BaseClassTest{
    private Header header;
    private SignUpLogInPage signUpLogInPage;
    private UserData userData;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
        userData = new UserData();
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
    @Test(dataProvider = "signUpDataSecondPage")
    public void signUpSecondTestCases(String password, String date, String month, String year, String firstName, String lastName, String company, String addressOne, String addressTwo, String state, String city, String zipCode, String mobileNumber){
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.signUpEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertEquals(signUpLogInPage.isAccountInfoText(), "ENTER ACCOUNT INFORMATION");
        signUpLogInPage.setGender();
        signUpLogInPage.signUpPasswordClear();
        signUpLogInPage.setSignUpPasswordField(password);
        signUpLogInPage.setDaysDropDown(Integer.parseInt(date));
        signUpLogInPage.setMonthsDropDown(Integer.parseInt(month));
        signUpLogInPage.setYearsDropDown(year);
        signUpLogInPage.setNewsLetter();
        signUpLogInPage.setOffers();
        signUpLogInPage.signUpFirstNameClear();
        signUpLogInPage.setFirstNameField(firstName);
        signUpLogInPage.signUpLastNameClear();
        signUpLogInPage.setLastNameField(lastName);
        signUpLogInPage.companyFieldClear();
        signUpLogInPage.setCompanyField(company);
        signUpLogInPage.addressOneClear();
        signUpLogInPage.setAddressOne(addressOne);
        signUpLogInPage.addressTwoClear();
        signUpLogInPage.setAddressTwo(addressTwo);
        signUpLogInPage.stateClear();
        signUpLogInPage.setStateField(state);
        signUpLogInPage.cityClear();
        signUpLogInPage.setCityField(city);
        signUpLogInPage.zipcodeClear();
        signUpLogInPage.setZipcodeField(zipCode);
        signUpLogInPage.mobileNumberClear();
        signUpLogInPage.setMobileNumberField(mobileNumber);
        signUpLogInPage.setCreateAccountButton();
        signUpLogInPage.setContinueButton();
    }
}