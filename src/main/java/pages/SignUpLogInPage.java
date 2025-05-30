package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import untilities.BasePage;
import untilities.UserData;

import java.util.List;

public class SignUpLogInPage extends BasePage {
    UserData userData = new UserData();

    public SignUpLogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    private WebElement newUserSignUpText;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signUpNameField;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signUpEmailField;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
    private WebElement accountIfoText;
    @FindBy(id = "uniform-id_gender1")
    private WebElement maleGender;
    @FindBy(id = "uniform-id_gender2")
    private WebElement femaleGender;
    @FindBy(id = "password")
    private WebElement signUpPasswordField;
    @FindBy(id = "days")
    private WebElement daysDropDown;
    @FindBy(id = "months")
    private WebElement monthsDropDown;
    @FindBy(id = "years")
    private WebElement yearsDropDown;
    @FindBy(id = "newsletter")
    private WebElement newsLetter;
    @FindBy(id = "optin")
    private WebElement offers;
    @FindBy(id = "first_name")
    private WebElement firstNameField;
    @FindBy(id = "last_name")
    private WebElement lastNameField;
    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement addressOneField;
    @FindBy(id = "address2")
    private WebElement addressTwoField;
    @FindBy(id = "state")
    private WebElement stateField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "zipcode")
    private WebElement zipcodeField;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    private WebElement accountCreatedText;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@class='login-form']")
    private WebElement loginInYourAccountText;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//form[@action='/login']/p")
    private WebElement incorrectEmailValidationMsg;
    @FindBy (xpath = "//form[@action='/signup']/p")
    private WebElement existedEmailValidationMsg;


    public boolean isNewUserSignUpText() {
        return newUserSignUpText.isDisplayed();
    }

    public void setSignUpNameField(String signUpName) {
        signUpNameField.sendKeys(signUpName);
    }

    public void setSignUpEmailField(String signUpEmail) {
        signUpEmailField.sendKeys(signUpEmail);
    }

    public void setSignUpButton() {
        signUpButton.click();
    }

    public String isAccountInfoText() {
        return accountIfoText.getText();
    }


    public void setGender() {
        if (userData.gender.equals("male")) {
            maleGender.click();
        } else {
            femaleGender.click();
        }
    }

    public void setSignUpPasswordField(String password) {
        signUpPasswordField.sendKeys(password);
    }

    public void setDaysDropDown(int days) {
        Select select = new Select(daysDropDown);
        select.selectByIndex(days);
    }

    public void setMonthsDropDown(int months) {
        Select select = new Select(monthsDropDown);
        select.selectByIndex(months);
    }

    public void setYearsDropDown(String years) {
        Select select = new Select(yearsDropDown);
        select.selectByVisibleText(years);
    }

    public void setNewsLetter() {
        newsLetter.click();
    }

    public void setOffers() {
        offers.click();
    }

    public void setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setCompanyField(String company) {
        companyField.sendKeys(company);
    }

    public void setAddressOne(String addressOne) {
        addressOneField.sendKeys(addressOne);
    }

    public void setAddressTwo(String addressTwo) {
        addressTwoField.sendKeys(addressTwo);
    }

    public void setStateField(String state) {
        stateField.sendKeys(state);
    }

    public void setCityField(String city) {
        cityField.sendKeys(city);
    }

    public void setZipcodeField(String zipCode) {
        zipcodeField.sendKeys(zipCode);
    }

    public void setMobileNumberField(String mobileNumber) {
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void setCreateAccountButton() {
        createAccountButton.click();
    }

    public String isAccountCreatedText() {
        return accountCreatedText.getText();
    }

    public void setContinueButton() {
        continueButton.click();
    }

    public boolean isLoginToYourAccountText() {
        return loginInYourAccountText.isDisplayed();
    }

    public void setLoginEmailField(String loginEmail) {
        loginEmailField.sendKeys(loginEmail);
    }

    public void setLoginPasswordField(String loginPassword) {
        loginPasswordField.sendKeys(loginPassword);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public boolean isInvalidEmailPassMag() {
        return incorrectEmailValidationMsg.isDisplayed();
    }
    public boolean isExistedEmailMsg(){
        return existedEmailValidationMsg.isDisplayed();
    }
    public void logInEmailFieldClear(){
        loginEmailField.click();
    }
    public void logInPasswordClear(){
        loginPasswordField.clear();
    }
    public void signUpNameFieldClear(){
        signUpNameField.clear();
    }
    public void signUpEmailFieldClear(){
        signUpEmailField.clear();
    }
}
