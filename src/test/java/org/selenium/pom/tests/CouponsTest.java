package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.DataProviders.MyDataProviders;
import org.selenium.pom.api.actions.AddToCartApi;
import org.selenium.pom.objects.Coupon;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CouponsTest extends BaseTest {

    @Test(dataProvider = "getCoupons",dataProviderClass = MyDataProviders.class,
            description = "Check Guest checkout Using Coupons")
    public void guestCheckoutUsingCoupons(String coupon) {

        CartPage cartPage=new CartPage(getDriver()).load();

       AddToCartApi addToCartApi=new AddToCartApi();

       addToCartApi.addToCart(1198,1);

       injectCookiesToBrowser(addToCartApi.getCookies());

       String coupontext=cartPage.load().
               enterCoupon(coupon).applyCoupon().getCouponText();
        Assert.assertTrue(coupontext.contains(coupon));
       CheckOutPage checkOutPage=cartPage.clickCheckoutBtn();
       Assert.assertTrue(checkOutPage.getCouponText().contains(coupontext));
    }
}
