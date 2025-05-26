package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_description']//a")
    private WebElement firstProductName;
    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']//p")
    private WebElement firstProductPrice;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    private WebElement addressFirstLastName;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][1]")
    private WebElement companyName;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][2]")
    private WebElement addressLine1;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][3]")
    private WebElement addressLine2;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
    private WebElement cityStatePinCode;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_phone']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    private WebElement cardNameField;
    @FindBy(xpath = "//input[@data-qa='card-number']")
    private WebElement cardNumberField;
    @FindBy(xpath = "//input[@data-qa='cvc']")
    private WebElement cvcField;
    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    private WebElement expiryMonthField;
    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    private WebElement expiryYearField;
    @FindBy(id = "submit")
    private WebElement payConfirmButton;
    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
    private WebElement orderConfirmMsg;
    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/div/a")
    private WebElement continueButton;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement downloadInvoice;


    public String setFirstProductName() {
        System.out.println("checkout first product name: " + firstProductName.getText());
        return firstProductName.getText();
    }

    public String setFirstProductPrice() {
        System.out.println("checkout first product price: " + firstProductPrice.getText());
        return firstProductPrice.getText();
    }

    public String setAddressFirstLastName() {
        System.out.println("First last name: " + addressFirstLastName.getText());
        return addressFirstLastName.getText();
    }

    public String setCompanyName() {
        System.out.println("companyName: " + companyName.getText());
        return companyName.getText();
    }

    public String setAddressLine1() {
        System.out.println("addressLine1: " + addressLine1.getText());
        return addressLine1.getText();
    }

    public String setAddressLine2() {
        System.out.println("addressLine2: " + addressLine2.getText());
        return addressLine2.getText();
    }

    public String setCityStatePinCode() {
        System.out.println("cityStatePinCode: " + cityStatePinCode.getText());
        return cityStatePinCode.getText();
    }

    public String setPhoneNumber() {
        System.out.println("phoneNumber: " + phoneNumber.getText());
        return phoneNumber.getText();
    }

    public void setPlaceOrderButton() {
        placeOrderButton.click();
    }
    public void setCardNameField(String cardName) {
        cardNameField.sendKeys(cardName);
    }
    public void setCardNumberField(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }
    public void setCvcField(String cvc) {
        cvcField.sendKeys(cvc);
    }
    public void setExpiryMonthField(String ExpiryMonth) {
        expiryMonthField.sendKeys(ExpiryMonth);
    }
    public void setExpiryYearField(String ExpiryYear) {
        expiryYearField.sendKeys(ExpiryYear);
    }
    public void setPayConfirmButton(){
        payConfirmButton.click();
    }
    public boolean isOrderConfirmMsgDisplay(){
        return orderConfirmMsg.isDisplayed();
    }
    public void setContinueButton(){
        continueButton.click();
    }
    public void setDownloadInvoice (){
        downloadInvoice.click();
    }
}
