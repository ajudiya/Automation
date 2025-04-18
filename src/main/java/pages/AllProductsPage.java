package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

import java.util.List;

public class AllProductsPage extends BasePage {
    Actions actions = new Actions(driver);
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement allProductText;
    @FindBy(xpath = "//div[@class='col-sm-4']")
    private List<WebElement> prouctList;
    @FindBy(xpath = "//div[@class='col-sm-4'][1]//div[@class='single-products']")
    private WebElement firstProductHover;
    @FindBy(xpath = "//div[@class='col-sm-4'][1]//a[@class='btn btn-default add-to-cart']")
    private WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstProductViewButton;
    public boolean isAllProductText(){
        return allProductText.isDisplayed();
    }
    public int isAllProduct(){
        int allProducts = prouctList.size();
        System.out.println("Product count is "+allProducts);
        return allProducts;
    }
    public void setFirstProductHover(){
        actions.moveToElement(firstProductHover).perform();
    }
    public void setFirstProductAddToCartButton(){
        firstProductAddToCartButton.click();
    }
    public void setFirstProductViewButton(){
        firstProductViewButton.click();
    }

    // new test

    // second tests

    // Third tests
}
