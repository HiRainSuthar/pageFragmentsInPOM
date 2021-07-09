package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name="btnK")
    private WebElement searchBtn;

    public void goTo() {
        driver.get("https://www.google.com");
    }

    public void search(String keywordToSearch) throws InterruptedException {
        searchBox.sendKeys(keywordToSearch);
        Thread.sleep(2000);
        searchBtn.click();
    }

    public  GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateTitle(){
        return driver.getTitle().equals("Google");
    }

    public GoogleSearchResult getSearchResult(){
        return new GoogleSearchResult(driver);
    }

    public GooglePageNavigation getPageNavigation(){
        return new GooglePageNavigation(driver);
    }
}
