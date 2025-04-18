import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.Header;
import pages.ProductDetailPage;
import untilities.UserData;

public class SearchProductTest extends BaseTest{
    private Header header;
    private AllProductsPage allProductsPage;
    private UserData userData;
    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        allProductsPage = new AllProductsPage(driver);
        userData = new UserData();
    }
    @Test
    public void searchProductTest(){
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setProductLink();
        Assert.assertTrue(allProductsPage.isAllProductText());
        allProductsPage.setSearchBarField(userData.search);
        allProductsPage.setSearchButton();
        Assert.assertTrue(allProductsPage.setProductNameContain());
    }
}
