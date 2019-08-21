package Tests;

import Pages.AppPage;
import Pages.CreateAppPage;
import Properties.TestConstants;
import Base.IntialSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class pliovoTestPage {

    WebDriver driver;
    IntialSetUp setup = new IntialSetUp();

    @BeforeClass
    public void setUp(){
        System.out.println("Inside Set Up Method");
        driver = setup.driverSetUp(TestConstants.applicationURL,TestConstants.FF_BROWSER);

    }
    @AfterMethod
    public void quitBrowser(){
        setup.quitDriver();
    }


    @Test()
    public void loginTest() throws InterruptedException {
        AppPage testPage = new AppPage(driver);
        CreateAppPage createAppPage = new CreateAppPage(driver);
        createAppPage.clickCreateApp();
        testPage.clickStartedButton();
        testPage.clickCreateNewPage();
        testPage.createNewPageName();
        testPage.clickMessageingModule();
        testPage.dragSMSModule();
       // testPage.connectModule();
        testPage.fillDetails();
        testPage.dragEmailModule();
        testPage.dragBasic();
    }
}
