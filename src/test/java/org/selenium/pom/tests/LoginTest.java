package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.Utils.FakerUtils;
import org.selenium.pom.api.actions.AddToCartApi;
import org.selenium.pom.api.actions.SignupApi;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test
    public void loginDuringCheckout() throws IOException, InterruptedException {
        String userName="demouser"+new FakerUtils().generateRandomNumber();
        //setup user
        User user=new User().
                setUsername(userName).
                setPassword("demopwd").setEmail(userName+"@gmail.com");
        SignupApi signupApi=new SignupApi();
        signupApi.registerUser(user);

        //Add to cart now
        Product product=new Product(1215);
        AddToCartApi addToCartApi=new AddToCartApi();
        addToCartApi.addToCart(product.getId(),1);
        CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(addToCartApi.getCookies());
        checkOutPage.load();
        Thread.sleep(5000);
        checkOutPage.clickLogin().login(user);
        Thread.sleep(5000);
        Assert.assertTrue(checkOutPage.getProductName().contains(product.getName()));
    }
}
