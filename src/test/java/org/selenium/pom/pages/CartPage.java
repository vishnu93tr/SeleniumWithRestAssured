package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;

public class CartPage extends BasePage {
    private final By productName=By.cssSelector("td[class='product-name'] a");
    private final By CheckoutBtn=By.cssSelector(".checkout-button");
    private final By coupons=By.cssSelector("#coupon_code");
    private final By couponText=By.xpath("//tr[contains(@class,'cart-discount')]/th");
    private final By applyCoupon=By.cssSelector("button[value='Apply coupon']");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }
    public CheckOutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(CheckoutBtn)).click();
        return new CheckOutPage(driver);
    }
    public CartPage load(){
        load("/cart/");
        return this;
    }
    public CartPage enterCoupon(String coupon){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(coupons));
        element.clear();
        element.sendKeys(coupon);
        return this;
    }

    public CartPage applyCoupon(){
        wait.until(ExpectedConditions.elementToBeClickable(applyCoupon)).click();
        return this;
    }
    public String getCouponText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(couponText)).getText();
    }
}
