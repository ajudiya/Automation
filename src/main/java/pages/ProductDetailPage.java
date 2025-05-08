package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class='product-information']/h2")
    private WebElement productName;
    @FindBy (xpath = "//div[@class='product-information']/p[1]")
    private WebElement productCategory;
    @FindBy (xpath = "//div[@class='product-information']/p[2]")
    private WebElement productAvailability;
    @FindBy (xpath = "//div[@class='product-information']/p[3]")
    private WebElement productCondition;
    @FindBy (xpath = "//div[@class='product-information']/p[4]")
    private WebElement productBrand;

    public String setProductName(){
        System.out.println("Product name: "+productName.getText());
        return productName.getText();
    }
    public boolean isProductCategory(){
        System.out.println("Product category: "+productCategory.getText());
        return productCategory.isDisplayed();
    }
    public boolean isProductAvailability(){
        System.out.println("Product availability: "+productAvailability.getText());
        return productAvailability.isDisplayed();
    }
    public boolean isProductCondition(){
        System.out.println("Product condition: "+productCondition.getText());
        return productCondition.isDisplayed();
    }
    public boolean isProductBrand(){
        System.out.println("Product brand: "+productBrand.getText());
        return productBrand.isDisplayed();
    }
}