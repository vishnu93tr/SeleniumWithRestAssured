package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.pages.components.ProductThumbNail;

public class StorePage extends BasePage {
    private final By searchfield=By.xpath("//input[contains(@id,'woocommerce')]");
    private final By searchButton=By.cssSelector("button[value='Search']");
    private final By title=By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By productName=By.cssSelector(".woocommerce-loop-product__title");
    private ProductThumbNail productThumbNail;

    public ProductThumbNail getProductThumbNail() {
        return productThumbNail;
    }

    public StorePage(WebDriver driver) {
        super(driver);
        productThumbNail=new ProductThumbNail(driver);
    }
    public StorePage enterIntoSearchField(String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
        element.clear();
        element.sendKeys(text);
        return this;
    }
    public StorePage clickOnSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }
    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public StorePage load(){
        load("/store");
        return this;
    }
    public String getProductName(){
        return wait.until(ExpectedConditions.elementToBeClickable(productName)).getText();
    }
    public ProductPage clickOnProduct(){
        driver.findElement(productName).click();
        return new ProductPage(driver);
    }
}
