import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllProductsPage;
import pages.CartPage;
import pages.Header;
import pages.ProductDetailPage;
import untilities.UserData;

public class AddReviewsOnProduct extends BaseTest{
    private Header header;
    private AllProductsPage allProductsPage;
    private CartPage cartPage;
    private UserData userData;
    private ProductDetailPage productDetailPage;
    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        allProductsPage = new AllProductsPage(driver);
        userData = new UserData();
        js = (JavascriptExecutor) driver;
        cartPage = new CartPage(driver);
        sf = new SoftAssert();
        productDetailPage = new ProductDetailPage(driver);
    }
    @Test
    public void addReviewsTest(){
        header.setProductLink();
        Assert.assertEquals(allProductsPage.isH2TitleTextDisplayed(), "ALL PRODUCTS");
        js.executeScript("window.scrollBy(0, 250)");
        allProductsPage.setViewProductButton();
        Assert.assertTrue(productDetailPage.isWriteYourReviewsText());
        productDetailPage.setReviewName(userData.reviewName);
        productDetailPage.setReviewEmail(userData.reviewEmail);
        productDetailPage.setReviewComment(userData.reviewComment);
        productDetailPage.setReviewSubmitButton();
        Assert.assertTrue(productDetailPage.isWriteYourReviewsText());
    }
}
