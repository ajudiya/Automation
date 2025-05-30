package untilities;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class UserData {
    WebDriver driver;

    Random random = new Random();
    public String signUpName = "Jay";
    public String signUpEmail = "jai.patel+"+random.nextInt(1000)+"@gmail.com";
    public String gender = "male";
    public String signUpPassword = "Jay@1234";
    public String days = "1";
    public String months = "1";
    public String years = "1990";
    public String firstName = "Jay";
    public String lastName = "Patel";
    public String company = "Ajudiya Group";
    public String addressOne = "World Trade Center";
    public String addressTwo = "corporate area";
    public String state = "Gujarat";
    public String city = "Ahmedabad";
    public String zipcode = "382481";
    public String mobileNumber = "9898989898";
    public String loginEmail = "jai.ajudiya@gmail.com";
    public String loginPassword = "Jay@1234";
    public String inValidLoginEmail = "jai.ajudiyaaa@gmail.com";
    public String file = "/home/ganesha/Downloads/file-example_PDF_1MB.pdf";
    public String search = "White";
    public String subscriptionEmail = "jai.patel@gmail.com";
    public String cardName = "Jay Patel";
    public String cardNumber = "424242424242";
    public String cvc = "123";
    public String expiryMonth = "12";
    public String expiryYear = "2026";
    public String reviewName = "Jay";
    public String reviewEmail = "jay.patel@gmail.com";
    public String reviewComment = "Awesome products, suggest to buy";

    public void handleAlert(){
        driver.switchTo().alert().dismiss();
    }
}