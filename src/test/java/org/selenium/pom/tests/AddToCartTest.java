package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.DataProviders.MyDataProviders;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Test(dataProvider = "getStoreProducts",dataProviderClass = MyDataProviders.class)
    public void addToCartFromStorePage(Product product) {
        CartPage cartPage=new StorePage(getDriver()).
                load().getProductThumbNail().
                clickAddToCartBtn(product.getName()).
                clickOnViewCart();
        Assert.assertEquals(cartPage.getProductName(),product.getName());
    }
    @Test(dataProvider = "getFeaturedProducts",dataProviderClass = MyDataProviders.class)
    public void addToCartForFeaturedProducts(Product product){
            CartPage cartPage=new HomePage(getDriver()).
                    load().getProductThumbNail().
                    clickAddToCartBtn(product.getName()).
                    clickOnViewCart();
            Assert.assertEquals(cartPage.getProductName(),product.getName());
    }

}
