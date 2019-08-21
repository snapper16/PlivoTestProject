package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateAppPage {
    WebDriver driver;
    @FindBy(how = How.ID,using="link-create")
    private WebElement createApp;


    public CreateAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void clickCreateApp() throws ElementClickInterceptedException {
        createApp.click();
    }

}
