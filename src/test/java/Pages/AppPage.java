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
import java.util.concurrent.TimeUnit;

public class AppPage {
    WebDriver driver;

    @FindBy(how = How.XPATH,using="//button[contains(text(),'get started!')]")
    private WebElement getStarted;

    /*@FindBy(how = How.XPATH,using="//button[contains(@title,'Let\'s get started!')]")
    private WebElement getStarted;*/

    @FindBy(how = How.ID,using="add-page")
    private  WebElement createNewPage;

    @FindBy(how = How.XPATH,using="//*[@id='create-dialog']/form/p/input")
    private  WebElement newPageName;

    @FindBy(how = How.XPATH,using="/html/body/div[20]/div[3]/button[1]")
    private WebElement createPageButton;

    @FindBy(how = How.XPATH,using="//a[contains(text(),'Messaging')]")
    private WebElement messageButton;

    @FindBy(how = How.XPATH,using="//a[contains(text(),'Basic')]")
    private WebElement basicButton;


    @FindBy(how = How.XPATH,using="//*[@id='accordion']/div[4]/ul/li[3]")
    private  WebElement sendSMSButton;

    @FindBy(how  = How.XPATH, using="//div[@id='module-1']/div[5]/div")     //div[@id='module-1']/div[5]/div
    private WebElement connectorStartPoint;

    @FindBy(how = How.XPATH,using = "//div[@id='module-4']/div[2]/div")    //*[@id="rec-697858"]
    private WebElement connectorEndPoint;

    @FindBy(how = How.XPATH,using = "//*[@id='module-2']/div[1]/div[3]/div/div[1]/div[2]/textarea")
    private WebElement phoneNum;

    @FindBy(how = How.XPATH,using = "//*[@id='module-2']/div[1]/div[3]/div/div[2]/div/table/tbody/tr/td[1]/div/textarea")
    private WebElement messageTest;

    @FindBy(how = How.XPATH,using="//*[@id='accordion']/div[4]/ul/li[2]")
    private  WebElement sendEmailButton;

    @FindBy(how = How.XPATH,using = "//*[text()='Start']//ancestor::div[contains (@id, \"module-1\")]//div[contains (@class, 'draggable')]")
    private WebElement connectorFromStart;

    @FindBy(how = How.XPATH,using = "//div[text()='Send an SMS']//ancestor::div[contains (@id,\"module\")]//div[contains (@class, 'droppable')]")
    private WebElement connectorToSMS;

    @FindBy(how = How.XPATH,using = "//*[text()='Send an SMS']//ancestor::div[contains (@id, \"module\")]//div[contains (@class, 'draggable') and contains(@class,'syn-node-attached-e')]")
    private WebElement connectorFromSMSToEmail;

    @FindBy(how = How.XPATH,using = "//div[text()='Send an SMS']//ancestor::div[contains (@id,\"module\")]//div[contains (@class, 'draggable') and contains(@class,'syn-node-attached-w')]")
    private WebElement connectorFromSMSToExit;


    @FindBy(how = How.XPATH,using = "//div[text()='Send an Email']//ancestor::div[contains (@id,\"module\")]//div[contains (@class, 'droppable')]")
    private WebElement connectorToEmail;


    @FindBy(how = How.XPATH,using = "//div[text()='Exit App']//ancestor::div[contains (@id,\"module-4\")]//div[contains (@class, 'droppable')]")
    private WebElement connectorToExit;

    @FindBy(how = How.NAME,using="smtp_url")
    private  WebElement emailHost;
    @FindBy(how = How.NAME,using="port")
    private  WebElement emailPort;
    @FindBy(how = How.NAME,using="username")
    private  WebElement emailUseName;
    @FindBy(how = How.NAME,using="password")
    private  WebElement emailPassword;
    @FindBy(how = How.XPATH,using="//*[@id='module-3']/div[1]/div[3]/div/div[2]/div[1]/div[2]/div/textarea") //*[@id="module-3"]/div[1]/div[3]/div/div[2]/div[1]/div[2]/div/textarea
    private  WebElement emailFrom;
    @FindBy(how = How.XPATH,using="//*[@id='module-3']/div[1]/div[3]/div/div[2]/div[2]/div[2]/div/textarea")
    private  WebElement emailTo;
    @FindBy(how = How.XPATH,using="//*[@id='module-3']/div[1]/div[3]/div/div[2]/div[3]/div[2]/div/textarea")
    private  WebElement emailSubject;
    @FindBy(how = How.XPATH,using="//*[@id='module-3']/div[1]/div[3]/div/div[2]/div[4]/div[2]/div/textarea")
    private  WebElement emailCC;
    @FindBy(how = How.XPATH,using="//*[@id='module-3']/div[1]/div[3]/div/div[3]/div/div/table/tbody/tr/td[1]/div/textarea")
    private  WebElement emailMes;

    @FindBy(how = How.XPATH,using="//*[@id='accordion']/div[1]/ul/li[1]")
    private  WebElement exitApp;




    public AppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void clickStartedButton(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'get started!')]")));
        getStarted.click();
    }

    public void clickCreateNewPage(){
        createNewPage.click();
    }

    public void createNewPageName() throws InterruptedException {
      //  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='create-dialog']/form")));
        newPageName.clear();
        newPageName.sendKeys("testPage");
        createPageButton.click();
      //  driver.switchTo().defaultContent();

    }

    public void clickMessageingModule() throws InterruptedException {
        Thread.sleep(2000);
        messageButton.click();
    }

    public void dragSMSModule() throws InterruptedException {
        Actions a = new Actions(driver);
        Thread.sleep(2000);
        a.dragAndDropBy(sendSMSButton, 800,116).build().perform();
        Point point1 = connectorStartPoint.getLocation();
        int xcord1 = point1.getX();
        int ycord1 = point1.getY();
        System.out.println("xcord : "+xcord1);
        System.out.println("ycord : "+ycord1);

    }

    public void connectStartToSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        Actions actions = new Actions(driver);
        actions.clickAndHold(connectorFromStart).moveToElement(connectorToSMS).release().build().perform();
        TimeUnit.SECONDS.sleep(1);

    }

    public void connectSMStoEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        Actions actions = new Actions(driver);
        actions.clickAndHold(connectorFromSMSToEmail).moveToElement(connectorToEmail).release().build().perform();
        TimeUnit.SECONDS.sleep(1);

    }


    public void connectSMStoExit() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        Actions actions = new Actions(driver);
        actions.clickAndHold(connectorFromSMSToExit).moveToElement(connectorToExit).release().build().perform();
        TimeUnit.SECONDS.sleep(1);

    }

    public void fillDetails(){
        phoneNum.clear();
        phoneNum.sendKeys("9035458616");
        messageTest.clear();
        messageTest.sendKeys("Hello World");
    }

    public void dragEmailModule() throws InterruptedException {
        Actions a = new Actions(driver);
        a.dragAndDropBy(sendEmailButton, 1200,300).build().perform();
        Thread.sleep(2000);
        emailHost.sendKeys("smtp.gmail.com");
        emailPort.sendKeys("465");
        emailPort.click();
        emailUseName.click();
        emailUseName.sendKeys("abc@gmail.com");
        emailPassword.sendKeys("12345");
        emailFrom.sendKeys("abc@gmail.com");
        emailTo.sendKeys("test@gmail.com");
        emailSubject.sendKeys("plivotest");
        emailCC.sendKeys("test1@gmail.com");
        emailMes.sendKeys("test");

    }

    public void dragBasic() throws InterruptedException {
        basicButton.click();
        Actions a = new Actions(driver);
        a.dragAndDropBy(exitApp, 400,300).build().perform();
        Thread.sleep(1000);

    }










}
