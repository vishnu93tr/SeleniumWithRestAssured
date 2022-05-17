package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.pages.CartPage;

public class ProductThumbNail extends BasePage {

    private final By viewCart=By.cssSelector("a[title='View cart']");

    public ProductThumbNail(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartBtn(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }
    public ProductThumbNail clickAddToCartBtn(String productName){
        By addToCartButton=getAddToCartBtn(productName);
        driver.findElement(addToCartButton).click();
        return this;
    }
    public CartPage clickOnViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        return new CartPage(driver);
    }
}
