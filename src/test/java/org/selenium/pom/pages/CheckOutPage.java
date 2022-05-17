package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckOutPage extends BasePage {
    private final By firstName=By.id("billing_first_name");
    private final By lastName=By.id("billing_last_name");
    private final By billingAddress=By.id("billing_address_1");
    private final By billingCity=By.id("billing_city");
    private final By billingPinCode=By.id("billing_postcode");
    private final By billingEmail=By.id("billing_email");
    private final By placeOrderButton=By.id("place_order");
    private final By login=By.cssSelector(".showlogin");
    private final By userName=By.id("username");
    private final By password=By.id("password");
    private final By loginButton=By.cssSelector("button[value='Login']");

    private final By billingCountry=By.id("billing_country");
    private final By billingState=By.id("billing_state");
    private final By directBankTransferRadioBtn=By.cssSelector("#payment_method_bacs");

    private final By cashOnDeliveryRadioBtn=By.cssSelector("#payment_method_cod");

    private final By productName=By.cssSelector("td[class='product-name']");

    private final By couponText=By.xpath("//tr[contains(@class,'cart-discount')]/th");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public CheckOutPage enterFirstName(String name){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        element.clear();
        element.sendKeys(name);
        return this;
    }
    public CheckOutPage enterLastName(String name){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        element.clear();
        element.sendKeys(name);
        return this;
    }
    public CheckOutPage selectBillingCountry(String country){
        Select select=new Select(driver.findElement(billingCountry));
        select.selectByVisibleText(country);
        return this;
    }
    public CheckOutPage enterBillingAddress(String address){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress));
        element.clear();
        element.sendKeys(address);
        return this;
    }
    public CheckOutPage enterBillingCity(String city){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(billingCity));
        element.clear();
        element.sendKeys(city);
        return this;
    }
    public CheckOutPage selectBillingState(String state){
        Select select=new Select(driver.findElement(billingState));
        select.selectByVisibleText(state);
        return this;
    }
    public CheckOutPage enterBillingPincode(String pincode){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(billingPinCode));
        element.clear();
        element.sendKeys(pincode);
        return this;
    }
    public CheckOutPage enterBillingEmail(String email){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmail));
        element.clear();
        element.sendKeys(email);
        return this;
    }
    public OrderConfirmationPage clickPlaceOrderButton(){
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        return new OrderConfirmationPage(driver);
    }
    public CheckOutPage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        return this;
    }
    public CheckOutPage enterUserName(String username){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        element.clear();
        element.sendKeys(username);
        return this;
    }
    public CheckOutPage enterPassword(String pass){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        element.clear();
        element.sendKeys(pass);
        return this;
    }
    public CheckOutPage login(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();;
        return this;
    }
    public CheckOutPage clickOnDirectBankTransfer(){
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        element.click();
        return this;
    }
    public CheckOutPage clickOnCashOnDelivery(){
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(cashOnDeliveryRadioBtn));
        element.click();
        return this;
    }
    public CheckOutPage login(User user){
        return enterUserName(user.getUsername()).
                enterPassword(user.getPassword()).
                clickLogin();
    }
    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectBillingCountry(billingAddress.getCountry()).
                enterBillingAddress(billingAddress.getBillingAddress()).
                enterBillingCity(billingAddress.getBillingCity()).
                selectBillingState(billingAddress.getState()).
                enterBillingPincode(billingAddress.getBillingPincode()).
                enterBillingEmail(billingAddress.getBillingEmail());
    }
    public CheckOutPage load(){
        load("/checkout/");
        return this;
    }
    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }
    public String getCouponText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(couponText)).getText();
    }

}
