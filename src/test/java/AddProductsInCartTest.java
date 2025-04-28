import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllProductsPage;
import pages.CartPage;
import pages.Header;
import untilities.UserData;
import org.testng.asserts.SoftAssert;

public class AddProductsInCartTest extends BaseTest {
    private Header header;
    private AllProductsPage allProductsPage;
    private CartPage cartPage;
    private UserData userData;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        allProductsPage = new AllProductsPage(driver);
        userData = new UserData();
        js = (JavascriptExecutor) driver;
        cartPage = new CartPage(driver);
        sf = new SoftAssert();
    }

    @Test
    public void addProductsInCartTest() {
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setProductLink();
        String firstProductName = allProductsPage.setFirstProductName();
        String SecondProductName = allProductsPage.setSecondProductName();
        String firstProductPrice = allProductsPage.setFirstProductPrice();
        String secondProductPrice = allProductsPage.setSecondProductPrice();
        js.executeScript("window.scrollBy(0, 250)");
        allProductsPage.setFirstProductHover();
        allProductsPage.setFirstProductAddToCartButton();
        allProductsPage.setContinueButton();
        allProductsPage.setSecondProductHover();
        allProductsPage.setSecondProductAddToCartButton();
        allProductsPage.setViewCartButton();
        sf.assertEquals(firstProductName, cartPage.setFirstProductName());
        sf.assertEquals(SecondProductName, cartPage.setSecondProductName());
        Assert.assertEquals(firstProductPrice, cartPage.setFirstProductPrice());
        Assert.assertEquals(secondProductPrice, cartPage.setSecondProductPrice());
        Assert.assertEquals(cartPage.setFirstProductPrice(), cartPage.setFirstProductTotalQty());
        Assert.assertEquals(cartPage.setSecondProductPrice(), cartPage.setSecondProductTotalQty());
    }

    @Test
    public void allProductsHoverTest() {
        js.executeScript("window.scrollBy(0, 250)");
        allProductsPage.funHoverAllProducts();
    }

    @Test
    public void addAllProductsToCartTest() {
        allProductsPage.funAddToCartAllProducts();
        header.setCartLink();
    }
}
