package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.Base.BasePage;

public class ProductPage extends BasePage {
    private final By productName=By.cssSelector(".product_title");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
