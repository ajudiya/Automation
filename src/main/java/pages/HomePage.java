package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import untilities.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {
    Actions actions = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-sm-4'][1]//div[@class='single-products']")
    private WebElement firstProductHover;
    @FindBy(xpath = "//div[@class='col-sm-4'][1]//a[@class='btn btn-default add-to-cart']")
    private WebElement firstProductAddToCartButton;
    @FindBy(xpath = "//p[@class='text-center']/a")
    private WebElement viewCartButton;

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
}
