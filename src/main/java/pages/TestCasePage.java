package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class TestCasePage extends BasePage {
    public TestCasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[@class='title text-center']/b")
    private WebElement testCaseText;
    public boolean isTextCaseText(){
        return testCaseText.isDisplayed();
    }
}
