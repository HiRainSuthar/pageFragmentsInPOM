import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.GoogleSearchPage;

public class GoogleSearchTest {

    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void initBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test(priority = 1)
    public void launchGoogle() throws InterruptedException {
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goTo();
        Assert.assertTrue(googleSearchPage.validateTitle());
    }

    @Test(priority = 2)
    public void validateGoogleResults() throws InterruptedException {
        googleSearchPage.search("arquillian graphene");
        Assert.assertEquals(googleSearchPage.getSearchResult().getCount(), 10);
        googleSearchPage.getSearchResult().printResult();
    }

    @Test(priority = 3)
    public void validateNews(){
        Assert.assertEquals(googleSearchPage.getPageNavigation().getCount(), 5);
        googleSearchPage.getPageNavigation().clickOnNews();
    }
}
