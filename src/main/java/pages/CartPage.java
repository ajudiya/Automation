package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr[@id='product-1']//h4")
    private WebElement firstProductName;
    @FindBy(xpath = "//tr[@id='product-2']//h4")
    private WebElement secondProductName;
    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']/p")
    private WebElement firstProductPrice;
    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']/p")
    private WebElement secondProductPrice;
    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']/button")
    private WebElement firstProductQty;
    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_quantity']/button")
    private WebElement secondProductQty;
    @FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_total']/p")
    private WebElement firstProductTotalQty;
    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_total']/p")
    private WebElement secondProductTotalQty;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//p//a[@href='/login']")
    private WebElement registerLogInLink;

    public String setFirstProductName() {
        System.out.println("Cart First Product Name: " + firstProductName.getText());
        return firstProductName.getText();
    }

    public String setSecondProductName() {
        System.out.println("Cart second Product Name: " + secondProductName.getText());
        return secondProductName.getText();
    }

    public String setFirstProductPrice() {
        System.out.println("Cart First Product price: " + firstProductPrice.getText());
        return firstProductPrice.getText();
    }

    public String setSecondProductPrice() {
        System.out.println("Cart Second Product price: " + secondProductPrice.getText());
        return secondProductPrice.getText();
    }

    public String setFirstProductQty() {
        System.out.println("Cart First Product qty: " + firstProductQty.getText());
        return firstProductQty.getText();
    }

    public String setSecondProductQty() {
        System.out.println("Cart Second Product qty: " + secondProductQty.getText());
        return secondProductQty.getText();
    }

    public String setFirstProductTotalQty() {
        System.out.println("Cart First Product qty: " + firstProductTotalQty.getText());
        return firstProductTotalQty.getText();
    }

    public String setSecondProductTotalQty() {
        System.out.println("Cart Second Product qty: " + secondProductTotalQty.getText());
        return secondProductTotalQty.getText();
    }
    public void setCheckoutButton(){
        checkoutButton.click();
    }
    public void setRegisterLogInLink(){
        registerLogInLink.click();
    }
}
