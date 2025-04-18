import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.Header;
import pages.ProductDetailPage;

public class VerifyAllProductsAndDetailTest extends BaseTest {
    private Header header;
    private AllProductsPage allProductsPage;
    private JavascriptExecutor js;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void inIt() {
        header = new Header(driver);
        allProductsPage = new AllProductsPage(driver);
        js = (JavascriptExecutor) driver;
        productDetailPage = new ProductDetailPage(driver);
    }

    @Test
    public void verifyAllProductAndDetailTest() {
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setProductLink();
        Assert.assertTrue(allProductsPage.isAllProductText());
        Assert.assertNotNull(allProductsPage.isAllProduct());
        allProductsPage.setFirstProductHover();
        js.executeScript("window.scrollBy(0,300)");
        // allProductsPage.setFirstProductAddToCartButton();
        allProductsPage.setFirstProductViewButton();
        Assert.assertEquals("Blue Top", productDetailPage.setProductName());
        Assert.assertTrue(productDetailPage.isProductCategory());
        Assert.assertTrue(productDetailPage.isProductAvailability());
        Assert.assertTrue(productDetailPage.isProductBrand());
        Assert.assertTrue(productDetailPage.isProductCondition());
    }
}
