import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestBeforeMethod {
    @BeforeMethod
    public void beforeTest(){
        System.out.println("Executed the before test");
    }
    @Test
    public void testOne(){
        System.out.println("Executed the test one.");
    }
    @Test
    public void testTwo(){
        System.out.println("Executed the test two.");
    }
}
