package org.selenium.pom.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.pages.HomePage;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(45));
    }
    public HomePage load(String endpoint){
        driver.get("https://askomdch.com" +endpoint);
        return null;
    }

}
