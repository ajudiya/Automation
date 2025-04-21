import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.SignUpLogInPage;
import untilities.UserData;

public class RegisterUser extends BaseTest{
    private Header header;
    private UserData userData;
    private SignUpLogInPage signUpLogInPage;
    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
        userData = new UserData();
    }
    @Test
    public void registerUser(){
        Assert.assertEquals("color: orange;",header.isHomePageVisible());
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.signUpEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION",signUpLogInPage.isAccountInfoText());
        signUpLogInPage.setGender();
        signUpLogInPage.setSignUpPasswordField(userData.signUpPassword);
        signUpLogInPage.setDaysDropDown(userData.days);
        signUpLogInPage.setMonthsDropDown(userData.months);
        signUpLogInPage.setYearsDropDown(userData.years);
        signUpLogInPage.setNewsLetter();
        signUpLogInPage.setOffers();
        signUpLogInPage.setFirstNameField(userData.firstName);
        signUpLogInPage.setLastNameField(userData.lastName);
        signUpLogInPage.setCompanyField(userData.company);
        signUpLogInPage.setAddressOne(userData.addressOne);
        signUpLogInPage.setAddressTwo(userData.addressTwo);
        signUpLogInPage.setStateField(userData.state);
        signUpLogInPage.setCityField(userData.city);
        signUpLogInPage.setZipcodeField(userData.zipcode);
        signUpLogInPage.setMobileNumberField(userData.mobileNumber);
        signUpLogInPage.setCreateAccountButton();
        Assert.assertEquals("ACCOUNT CREATED!",signUpLogInPage.isAccountCreatedText());
        signUpLogInPage.setContinueButton();
        header.setDeleteAccountButton();
        Assert.assertTrue(header.isAccountDeletedText());
        header.setContinueButton();
        Assert.assertEquals("color: orange;",header.isHomePageVisible());
    }
    @Test
    public void userAlreadyRegister(){
        Assert.assertEquals("color: orange;",header.isHomePageVisible());
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.loginEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertTrue(signUpLogInPage.isExistedEmailMsg());
    }
}
