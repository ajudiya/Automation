package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;
import untilities.UserData;

import java.util.List;

public class AllProductsPage extends BasePage {
    UserData userData = new UserData();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

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
    @FindBy(xpath = "//div[@class='col-sm-4'][2]//div[@class='single-products']")
    private WebElement secondProductHover;
    @FindBy(xpath = "//div[@class='col-sm-4'][2]//a[@class='btn btn-default add-to-cart']")
    private WebElement secondProductAddToCartButton;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstProductViewButton;
    @FindBy(id = "search_product")
    private WebElement searchBarField;
    @FindBy(id = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    private List<WebElement> productNameContain;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement continueButton;
    @FindBy(xpath = "//p[@class='text-center']/a")
    private WebElement viewCartButton;
    @FindBy(xpath = "//div[@class='col-sm-4'][1]//p")
    private WebElement firstProductName;
    @FindBy(xpath = "//div[@class='col-sm-4'][1]//h2")
    private WebElement firstProductPrice;
    @FindBy(xpath = "//div[@class='col-sm-4'][2]//p")
    private WebElement secondProductName;
    @FindBy(xpath = "//div[@class='col-sm-4'][2]//h2")
    private WebElement secondProductPrice;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='single-products']")
    private List<WebElement> allProductHover;
    @FindBy(xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//a/i")
    private List<WebElement> listAddToCartButton;

    public void funHoverAllProducts() {
        int productCount = allProductHover.size();
        System.out.println("Products count: " + productCount);
        for (WebElement hover : allProductHover) {
            if (hover.isDisplayed()) {
                actions.moveToElement(hover).perform();
            } else {
                System.out.println("Product is not display");
            }

        }
    }

    public void funAddToCartAllProducts() {
        int addToCartCount = listAddToCartButton.size();

        System.out.println("products count in HOME page: " + addToCartCount);
        for (WebElement cartButton : listAddToCartButton) {
            if (cartButton.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView(true);", cartButton);
                cartButton.click();
                continueButton.click();
            } else {
                System.out.println("cart button is not display");
            }
        }
    }
    public int isAllProductDisplayed(){
        return listAddToCartButton.size();
    }

    public boolean isAllProductText() {
        return allProductText.isDisplayed();
    }

    public int isAllProduct() {
        int allProducts = prouctList.size();
        System.out.println("Product count is " + allProducts);
        return allProducts;
    }

    public void setFirstProductHover() {
        actions.moveToElement(firstProductHover).perform();
    }

    public void setFirstProductAddToCartButton() {
        firstProductAddToCartButton.click();
    }

    public void setFirstProductViewButton() {
        firstProductViewButton.click();
    }

    public void setSearchBarField(String searchBar) {
        searchBarField.sendKeys(searchBar);
    }

    public void setSearchButton() {
        searchButton.click();
    }

    public boolean setProductNameContain() {
        return productNameContain.stream().allMatch(productNameContain -> productNameContain.getText().contains(userData.search));
    }

    public void setSecondProductHover() {
        actions.moveToElement(secondProductHover).perform();
    }

    public void setSecondProductAddToCartButton() {
        secondProductAddToCartButton.click();
    }

    public void setContinueButton() {
        continueButton.click();
    }

    public void setViewCartButton() {
        viewCartButton.click();
    }

    public String setFirstProductName() {
        System.out.println("First product Name: " + firstProductName.getText());
        return firstProductName.getText();
    }

    public String setFirstProductPrice() {
        System.out.println("First product Price: " + firstProductPrice.getText());
        return firstProductPrice.getText();
    }

    public String setSecondProductName() {
        System.out.println("Second product Name: " + secondProductName.getText());
        return secondProductName.getText();
    }

    public String setSecondProductPrice() {
        System.out.println("Second product Price: " + secondProductPrice.getText());
        return secondProductPrice.getText();
    }

    // new test

    // second tests

    // Third tests
}
