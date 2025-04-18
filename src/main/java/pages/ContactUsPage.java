package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import untilities.BasePage;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='contact-form']//h2[@class='title text-center']")
    private WebElement getInTouchText;
    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement subjectField;
    @FindBy(id = "message")
    private WebElement messageField;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUpload;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement submittedMagText;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homeButton;

    public boolean isGetInTouchText() {
        return getInTouchText.isDisplayed();
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setSubjectField(String subject) {
        subjectField.sendKeys(subject);
    }

    public void setMessageField(String message) {
        messageField.sendKeys(message);
    }

    public void setFileUpload(String file) {
        fileUpload.sendKeys(file);
    }

    public void setSubmitButton() {
        submitButton.click();
    }
    public boolean isSubmittedMsg(){
        return submittedMagText.isDisplayed();
    }
    public void setHomeButton(){
        homeButton.click();
    }
}
