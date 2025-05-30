import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.SignUpLogInPage;
import untilities.UserData;

import java.util.Objects;

public class RegisterUser extends BaseTest{
    private Header header;
    private UserData userData;
    private SignUpLogInPage signUpLogInPage;
    private HomePage homePage;

    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
        userData = new UserData();
        homePage = new HomePage(driver);
    }
    @Test
    public void verifyHomePage(){
        if (Objects.equals(homePage.homePageString(), "https://automationexercise.com/")){
            System.out.println("Verified the home page");
            Assert.assertEquals("color: orange;",header.isHomePageVisible());
        }
    }
    @Test
    public void createUser(){
        if (header != null) {
            header.setSignUpLogInLink();
        } else {
            System.out.println("ERROR: Header element was not found. Check locator or page state.");
        }
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.signUpEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION",signUpLogInPage.isAccountInfoText());
        signUpLogInPage.setGender();
        signUpLogInPage.setSignUpPasswordField(userData.signUpPassword);
        signUpLogInPage.setDaysDropDown(Integer.parseInt(userData.days));
        signUpLogInPage.setMonthsDropDown(Integer.parseInt(userData.months));
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
    }
    @Test
    public void userDeleteAfterRegisterUser(){
        createUser();
        header.setDeleteAccountButton();
        Assert.assertTrue(header.isAccountDeletedText());
        header.setContinueButton();
        Assert.assertEquals("color: orange;",header.isHomePageVisible());
    }
    @Test
    public void userAlreadyRegister(){
        verifyHomePage();
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.loginEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertTrue(signUpLogInPage.isExistedEmailMsg());
    }
}
