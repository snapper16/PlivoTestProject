package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IntialSetUp {
    public WebDriver driver;

    public WebDriver driverSetUp(String url, String browserType){
        String os = System.getProperty("os.name").toLowerCase();

        //handle ssl cert in chrome
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        //handle ssl cert in firefox
        FirefoxProfile fp = new FirefoxProfile();
        fp.setAcceptUntrustedCertificates(true);
        fp.setAssumeUntrustedCertificateIssuer(false);
        fp.setPreference("permissions.default.desktop-notification", 1);
        DesiredCapabilities ds = DesiredCapabilities.firefox();
        ds.setCapability(FirefoxDriver.PROFILE,fp);

        if (browserType.equalsIgnoreCase("firefox")){
            if (os.indexOf("mac") >=0){
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resources/firefox/mac/geckodriver");
            }else if (os.indexOf("win")>=0){
                //TO-DO as am working on MAC
            }
            driver = new FirefoxDriver(ds);
            driver.get(url);
            driver.manage().window().maximize();
        }else if (browserType.equalsIgnoreCase("chrome")){
            if (os.indexOf("mac") >=0){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chrome/mac/chromedriver");
            }else if (os.indexOf("win")>=0){
                //TO-DO as am working on MAC
            }
            driver = new ChromeDriver(desiredCapabilities);
            driver.get(url);
            driver.manage().window().maximize();


        }
        return driver;
    }

    public void quitDriver(){
        try {
            driver.quit();
        }catch (Exception e){
            System.out.println("error occured while quitting the driver");
        }
    }
}

