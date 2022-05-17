package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.pages.components.MyHeader;

public class AccountPage extends BasePage {
    private MyHeader myHeader;

    private final By orderslink=By.cssSelector(".woocommerce-MyAccount-navigation-link--orders");
    private final By orderNumber=By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)");

    public AccountPage(WebDriver driver) {
        super(driver);
        myHeader=new MyHeader(driver);
    }
    public AccountPage load(){
        load("/account/");
        return this;
    }
    public AccountPage clickOnOrders(){
        wait.until(ExpectedConditions.elementToBeClickable(orderslink)).click();
        return this;
    }
    public String getOrderNumber(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText();
    }
}
