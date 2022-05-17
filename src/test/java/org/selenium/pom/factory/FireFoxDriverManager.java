package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager implements DriverManager{
    @Override
    public WebDriver initializeDriver() {
        WebDriverManager.firefoxdriver().cachePath("Driver").setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
