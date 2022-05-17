package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.selenium.pom.constants.BrowserType;

public class DriverManagerCopy {

    public WebDriver initializeDriver(){
       WebDriver driver;
       String browser=System.getProperty("browser","CHROME");
       switch (BrowserType.valueOf(browser)){
           case CHROME:
               WebDriverManager.chromedriver().setup();
               driver=new ChromeDriver();
               break;
           case FIREFOX:
               WebDriverManager.firefoxdriver().setup();
               driver=new FirefoxDriver();
               break;
           case SAFARI:
               WebDriverManager.safaridriver().setup();
               driver=new SafariDriver();
               break;
           default:
               throw new RuntimeException("invalid browser name"+browser);
       }
       driver.manage().window().maximize();
       return driver;
    }
}
