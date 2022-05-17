package org.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.pages.AccountPage;
import org.selenium.pom.pages.StorePage;

public class MyHeader extends BasePage {

    private final By storeMenuLink=By.linkText("Store");
    private final By accountMenuLink=By.cssSelector("#menu-item-1237");
    public MyHeader(WebDriver driver) {
        super(driver);
    }

    public StorePage clickStoreMenuLink(){
        wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StorePage(driver);
    }
    public AccountPage clickAccountMenuLink(){
        wait.until(ExpectedConditions.elementToBeClickable(accountMenuLink)).click();
        return new AccountPage(driver);
    }
}
