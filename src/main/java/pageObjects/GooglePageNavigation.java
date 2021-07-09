package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePageNavigation {

    WebDriver driver;
    @FindBy(css = "[role='navigation'] .MUFPAc div span")
    private List<WebElement> navigation;

    public int getCount(){
        return navigation.size();
    }

    public void clickOnNews(){
        navigation.get(4).click();
    }

    public GooglePageNavigation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
