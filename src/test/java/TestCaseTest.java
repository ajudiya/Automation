import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.TestCasePage;

public class TestCaseTest extends BaseTest{
    private Header header;
    private TestCasePage testCasePage;
    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        testCasePage = new TestCasePage(driver);
    }
    @Test
    public void verifyTestCasePageLanded(){
        Assert.assertEquals("color: orange;", header.isHomePageVisible());
        header.setTestCasesLink();
        Assert.assertTrue(testCasePage.isTextCaseText());
    }
}
