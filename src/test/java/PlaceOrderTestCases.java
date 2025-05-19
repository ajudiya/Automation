import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import untilities.UserData;

import java.time.Duration;

public class PlaceOrderTestCases extends BaseTest {
    private Header header;
    private AllProductsPage allProductsPage;
    private HomePage homePage;
    private CartPage cartPage;
    private SignUpLogInPage signUpLogInPage;
    private UserData userData;
    private CheckoutPage checkoutPage;
    private RegisterUser registerUser;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        allProductsPage = new AllProductsPage(driver);
        js = (JavascriptExecutor) driver;
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
        userData = new UserData();
        checkoutPage = new CheckoutPage(driver);
        registerUser = new RegisterUser();
    }

    @Test
    public void placeOrderRegisterWhileCheckout() {
        js.executeScript("window.scrollBy(0, 250)");
        homePage.setFirstProductHover();
        homePage.setFirstProductAddToCartButton();
        homePage.setViewCartButton();
        cartPage.setCheckoutButton();
        cartPage.setRegisterLogInLink();
        Assert.assertTrue(signUpLogInPage.isNewUserSignUpText());
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.signUpEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", signUpLogInPage.isAccountInfoText());
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
        Assert.assertEquals("ACCOUNT CREATED!", signUpLogInPage.isAccountCreatedText());
        signUpLogInPage.setContinueButton();
        header.setCartLink();
        String productName = cartPage.setFirstProductName();
        String productPrice = cartPage.setFirstProductPrice();
        cartPage.setCheckoutButton();
        Assert.assertEquals(productName, checkoutPage.setFirstProductName());
        Assert.assertEquals(productPrice, checkoutPage.setFirstProductPrice());
        String deliveryAddressLineOne = "Mr. " + userData.firstName + " " + userData.lastName;
        String cityStateZipcode = userData.city + " " + userData.state + " " + userData.zipcode;
        Assert.assertEquals(deliveryAddressLineOne, checkoutPage.setAddressFirstLastName());
        Assert.assertEquals(userData.company, checkoutPage.setCompanyName());
        Assert.assertEquals(userData.addressOne, checkoutPage.setAddressLine1());
        Assert.assertEquals(userData.addressTwo, checkoutPage.setAddressLine2());
        Assert.assertEquals(cityStateZipcode, checkoutPage.setCityStatePinCode());
        Assert.assertEquals(userData.mobileNumber, checkoutPage.setPhoneNumber());
        js.executeScript("window.scrollBy(0, 400)");
        checkoutPage.setPlaceOrderButton();
        checkoutPage.setCardNameField(userData.cardName);
        checkoutPage.setCardNumberField(userData.cardNumber);
        checkoutPage.setCvcField(userData.cvc);
        checkoutPage.setExpiryMonthField(userData.expiryMonth);
        checkoutPage.setExpiryYearField(userData.expiryYear);
        checkoutPage.setPayConfirmButton();
        Assert.assertTrue(checkoutPage.isOrderConfirmMsgDisplay());
        checkoutPage.setContinueButton();
    }

    @Test
    public void placeOrderRegisterBeforeCheckout() {
        header.setSignUpLogInLink();
        signUpLogInPage.setSignUpNameField(userData.signUpName);
        signUpLogInPage.setSignUpEmailField(userData.signUpEmail);
        signUpLogInPage.setSignUpButton();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", signUpLogInPage.isAccountInfoText());
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
        signUpLogInPage.setContinueButton();
        js.executeScript("window.scrollBy(0, 250)");
        homePage.setFirstProductHover();
        homePage.setFirstProductAddToCartButton();
        homePage.setViewCartButton();
        cartPage.setCheckoutButton();
        js.executeScript("window.scrollBy(0, 400)");
        checkoutPage.setPlaceOrderButton();
        checkoutPage.setCardNameField(userData.cardName);
        checkoutPage.setCardNumberField(userData.cardNumber);
        checkoutPage.setCvcField(userData.cvc);
        checkoutPage.setExpiryMonthField(userData.expiryMonth);
        checkoutPage.setExpiryYearField(userData.expiryYear);
        checkoutPage.setPayConfirmButton();
        Assert.assertTrue(checkoutPage.isOrderConfirmMsgDisplay());
        checkoutPage.setContinueButton();
    }

    @Test
    public void placeOrderLoginBeforeCheckout() {
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        header.setSignUpLogInLink();
        Assert.assertTrue(signUpLogInPage.isLoginToYourAccountText());
        signUpLogInPage.setLoginEmailField(userData.loginEmail);
        signUpLogInPage.setLoginPasswordField(userData.loginPassword);
        signUpLogInPage.setLoginButton();
        Assert.assertTrue(header.isUsernameLoggedInText());

        js.executeScript("window.scrollBy(0, 300)");
        homePage.setFirstProductHover();
        homePage.setFirstProductAddToCartButton();
        homePage.setViewCartButton();
        cartPage.setCheckoutButton();
        js.executeScript("window.scrollBy(0, 400)");
        checkoutPage.setPlaceOrderButton();
        checkoutPage.setCardNameField(userData.cardName);
        checkoutPage.setCardNumberField(userData.cardNumber);
        checkoutPage.setCvcField(userData.cvc);
        checkoutPage.setExpiryMonthField(userData.expiryMonth);
        checkoutPage.setExpiryYearField(userData.expiryYear);
        checkoutPage.setPayConfirmButton();
        Assert.assertTrue(checkoutPage.isOrderConfirmMsgDisplay());
        checkoutPage.setContinueButton();
    }
    @Test
    public void removeProductsFromCart(){
        Assert.assertEquals(header.isHomePageVisible(), "color: orange;");
        js.executeScript("window.scrollBy(0, 300)");
        homePage.setFirstProductHover();
        homePage.setFirstProductAddToCartButton();
        homePage.setViewCartButton();
        cartPage.setRemoveProductButton();
    }
    @Test
    public void viewCategoryProducts(){
        Assert.assertTrue(homePage.isAllFiltersDisplayed()>0,"No categories are visible under the category section");
        homePage.setWomenCategoryFilter();
        homePage.setDressSubCategoryFilter();
        Assert.assertEquals(allProductsPage.isH2TitleTextDisplayed(), "WOMEN -  DRESS PRODUCTS");
        homePage.setMenCategoryFilter();
        homePage.settShirtsSubCategoryFilter();
    }
    @Test
    public void viewBrandProducts(){
        header.setProductLink();
        homePage.setPoloBrandFilter();
        Assert.assertEquals(allProductsPage.isH2TitleTextDisplayed(), "BRAND - POLO PRODUCTS");
    }
    @Test
    public void SearchProductsAndVerifyCartAfterLogin(){
        header.setProductLink();
        allProductsPage.setSearchBarField(userData.search);
        allProductsPage.setSearchButton();
        Assert.assertEquals(allProductsPage.isH2TitleTextDisplayed(), "SEARCHED PRODUCTS");
        allProductsPage.funAddToCartAllProducts();
        header.setCartLink();
        cartPage.setCheckoutButton();
        cartPage.setRegisterLogInLink();
        signUpLogInPage.setLoginEmailField(userData.loginEmail);
        signUpLogInPage.setLoginPasswordField(userData.loginPassword);
        signUpLogInPage.setLoginButton();
        header.setCartLink();
    }
}