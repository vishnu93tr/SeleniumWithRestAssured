package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Test
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage=new HomePage(getDriver()).
                load().getMyHeader().clickStoreMenuLink();
        Assert.assertEquals(storePage.getTitle(),"Store");
    }
    @Test
    public void NavigateFromStoreToProductPage(){
        StorePage storePage=new StorePage(getDriver()).load();
        String productName=storePage.getProductName();
        ProductPage productPage=storePage.clickOnProduct();
        Assert.assertEquals(productName,productPage.getProductName());
    }
}
