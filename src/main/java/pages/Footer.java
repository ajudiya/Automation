package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class Footer extends BasePage {

    public Footer(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class='single-widget']/h2")
    private WebElement subscriptionText;
    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailField;
    @FindBy(id = "subscribe")
    private WebElement subscriptionButton;
    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement successMsg;
    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    public boolean isSubscriptionText(){
        return subscriptionText.isDisplayed();
    }
    public void setSubscriptionEmailField(String subscriptionEmail){
        subscriptionEmailField.sendKeys(subscriptionEmail);
    }
    public void setSubscriptionButton(){
        subscriptionButton.click();
    }
    public boolean isSuccessMsg(){
        System.out.println("Message is displayed "+"'"+successMsg.getText()+"'");
        return successMsg.isDisplayed();
    }
    public void setScrollUpButton(){
        scrollUpButton.click();
    }
}
