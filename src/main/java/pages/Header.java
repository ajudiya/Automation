package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//i[@class='fa fa-home']")
    private WebElement homeLink;
    @FindBy (xpath = "//a[@style='color: orange;']")
    private WebElement homePageVisible;
    @FindBy (xpath = "//i[@class='material-icons card_travel']")
    private WebElement productLink;
    @FindBy (xpath = "//i[@class='fa fa-shopping-cart']")
    private WebElement cartLink;
    @FindBy (xpath = "//i[@class='fa fa-lock']")
    private WebElement signUpLogInLink;
    @FindBy (xpath = "//a[@href='/test_cases']//i[@class='fa fa-list']")
    private WebElement testCasesLink;
    @FindBy (xpath = "////a[@href='/api_list']//i[@class='fa fa-list']")
    private WebElement apiListLink;
    @FindBy (xpath = "//i[@class='fa fa-youtube-play']")
    private WebElement videoTutorialsLink;
    @FindBy (xpath = "//i[@class='fa fa-envelope']")
    private WebElement contactUsLink;
    @FindBy (xpath = "//ul/li[10]/a")
    private WebElement usernameLoggedIn;
    @FindBy (xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountButton;
    @FindBy (xpath = "//a[@href='/logout']")
    private WebElement logoutButton;
    @FindBy (xpath = "//h2[@data-qa='account-deleted']")
    private WebElement accountDeletedText;
    @FindBy (xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;
    public void setHomeLink(){
        homeLink.click();
    }
    public String isHomePageVisible(){
        return homePageVisible.getAttribute("style");
    }
    public void setSignUpLogInLink(){
        signUpLogInLink.click();
    }
    public boolean isUsernameLoggedInText(){
        System.out.println("username "+usernameLoggedIn.getText());
        return usernameLoggedIn.isDisplayed();
    }
    public void setDeleteAccountButton(){
        deleteAccountButton.click();
    }
    public boolean isAccountDeletedText(){
        return accountDeletedText.isDisplayed();
    }
    public void setContinueButton(){
        continueButton.click();
    }
    public void setLogoutButton(){
        logoutButton.click();
    }
    public void setContactUsLink(){
        contactUsLink.click();
    }
    public void setTestCasesLink(){
        testCasesLink.click();
    }
    public void setProductLink(){
        productLink.click();
    }
    public void setCartLink(){
        cartLink.click();
    }
}