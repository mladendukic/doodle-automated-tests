import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class SampleTest extends BaseTest {
    @Test(priority = 1, description = "User can search 1.")
    public void sampleTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickRegisterLink();
        Assert.assertTrue(true);
    }
}
