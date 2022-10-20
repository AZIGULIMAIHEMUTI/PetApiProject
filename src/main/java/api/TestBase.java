package api;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class TestBase {
    public WebDriver driver;
    public String browserName="chrome";

    public void browserSetUp(String url){

        //define the driver
        if(driver==null){
            if(browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }


            else if(browserName.equalsIgnoreCase("FireFox")){
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
            }

            else if(browserName.equalsIgnoreCase("IE")){
                InternetExplorerOptions internetExplorerOptions=new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver(internetExplorerOptions);
            }

            else if(browserName.equalsIgnoreCase("Edge")){
                EdgeOptions edgeOptions=new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver(edgeOptions);
            }

            else if(browserName.equalsIgnoreCase("Opera")){
                OperaOptions operaOptions=new OperaOptions();
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver(operaOptions);
            }

            assert driver != null;
            driver.manage().window().maximize();
            driver.get(url);
        }
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
