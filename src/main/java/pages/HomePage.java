package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import untilities.BasePage;
import untilities.UserData;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    Actions actions = new Actions(driver);
    Random random = new Random();
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-sm-4'][1]//div[@class='single-products']")
    private WebElement firstProductHover;

    @FindBy(xpath = "(//div[@class='col-sm-4'][1]//a[@class='btn btn-default add-to-cart'])[2]")
    private WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//p[@class='text-center']/a")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[@class='panel panel-default']")
    private List<WebElement> allCategoriesFilter;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[1]")
    private WebElement womenCategoryFilter;

    @FindBy (xpath = "(//div[@id='Women']/div/ul/li/a)[1]")
    private WebElement dressSubCategoryFilter;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[2]")
    private WebElement menCategoryFilter;

    @FindBy (xpath = "(//div[@id='Men']/div/ul/li/a)[1]")
    private WebElement tShirtsSubCategoryFilter;

    public void setFirstProductHover() {
        actions.moveToElement(firstProductHover).perform();
    }
    public void setFirstProductAddToCartButton() {
        firstProductAddToCartButton.click();
    }
    public void setViewCartButton() {
        viewCartButton.click();
    }
    public String homePageString() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }
    public int isAllFiltersDisplayed(){
        System.out.println("Number of categories in filter: "+allCategoriesFilter.size());
        return allCategoriesFilter.size();
    }
    public void setWomenCategoryFilter(){
        womenCategoryFilter.click();
    }
    public void setDressSubCategoryFilter(){
        dressSubCategoryFilter.click();
    }
    public void setMenCategoryFilter(){
        menCategoryFilter.click();
    }
    public void settShirtsSubCategoryFilter(){
        tShirtsSubCategoryFilter.click();
    }
}
