package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;

public class OrderConfirmationPage extends BasePage {

    private final By orderConfirmation=By.cssSelector(".woocommerce-notice--success");
    private final By orderNumber=By.cssSelector("li[class='woocommerce-order-overview__order order'] strong");
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }
    public String getOrderConfirmationText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));
        return driver.findElement(orderConfirmation).getText();
    }
    public String getOrderNumber(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText();
    }
}
