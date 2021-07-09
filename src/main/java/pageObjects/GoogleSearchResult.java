package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResult {

    WebDriver driver;
    @FindBy(css = "#search .g")
    private List<WebElement> results;

    public int getCount(){
        return results.size();
    }

    public void printResult(){
        for (int y = 0; y < results.size(); y++){
            System.out.println(results.get(y).getText());
        }
    }

    public GoogleSearchResult(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
