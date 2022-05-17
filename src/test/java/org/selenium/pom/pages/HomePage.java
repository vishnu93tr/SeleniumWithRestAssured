package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.Base.BasePage;
import org.selenium.pom.pages.components.MyHeader;
import org.selenium.pom.pages.components.ProductThumbNail;

public class HomePage extends BasePage {

    private MyHeader myHeader;
    private ProductThumbNail productThumbNail;

    public MyHeader getMyHeader() {
        return myHeader;
    }
    public ProductThumbNail getProductThumbNail() {
        return productThumbNail;
    }

    public HomePage(WebDriver driver) {

        super(driver);
        myHeader=new MyHeader(driver);
        productThumbNail=new ProductThumbNail(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

}
