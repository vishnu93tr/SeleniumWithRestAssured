package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.DataProviders.MyDataProviders;
import org.selenium.pom.Utils.FakerUtils;
import org.selenium.pom.api.actions.AddToCartApi;
import org.selenium.pom.api.actions.SignupApi;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends BaseTest {
    @Test(dataProvider = "getBillingInfo",dataProviderClass = MyDataProviders.class)
    public void guestCheckoutUsingDirectBankTransfer(BillingAddress billingAddress) {
        CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();
        AddToCartApi addToCartApi=new AddToCartApi();
        addToCartApi.addToCart(1215,1);
        injectCookiesToBrowser(addToCartApi.getCookies());

        OrderConfirmationPage orderConfirmationPage=checkOutPage.
                load().
                setBillingAddress(billingAddress).
                clickPlaceOrderButton();
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationText()
                ,"Thank you. Your order has been received.");
    }
    @Test(dataProvider = "getBillingInfo",dataProviderClass = MyDataProviders.class)
    public void loginCheckoutUsingDirectBankTransfer(BillingAddress billingAddress) throws IOException {
        CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();
        String userName="demouser"+ new FakerUtils().generateRandomNumber();
        User user=new User().
                setUsername(userName).
                setPassword("demopwd").
                setEmail(userName+"@gmail.com");

        SignupApi signupApi=new SignupApi();

        signupApi.registerUser(user);

        AddToCartApi addToCartApi=new AddToCartApi(signupApi.getCookies());

        addToCartApi.addToCart(1215,1);

        injectCookiesToBrowser(signupApi.getCookies());

        OrderConfirmationPage orderConfirmationPage=checkOutPage.load().
                setBillingAddress(billingAddress).
                clickOnDirectBankTransfer().
                clickPlaceOrderButton();
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationText()
                ,"Thank you. Your order has been received.");
    }
    @Test(dataProvider = "getBillingInfo",dataProviderClass = MyDataProviders.class)
    public void guestCheckoutUsingCashOnDelivery(BillingAddress billingAddress) throws IOException {

       CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();

       //for checkout we require product in cart,hence calling Addto cart API without registration as its guest

        AddToCartApi addToCartApi=new AddToCartApi();

        addToCartApi.addToCart(1198, 1);

        injectCookiesToBrowser(addToCartApi.getCookies());

       OrderConfirmationPage orderConfirmationPage=checkOutPage.
                                                    load().
                                                    setBillingAddress(billingAddress).
                                                    clickOnCashOnDelivery().
                                                    clickPlaceOrderButton();
       Assert.assertEquals(orderConfirmationPage.getOrderConfirmationText(),
               "Thank you. Your order has been received.");
    }
    @Test(dataProvider = "getBillingInfo",dataProviderClass = MyDataProviders.class)
    public void loginCheckoutusingCashOnDelivery(BillingAddress billingAddress) throws IOException {

        CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();

        //we need login here
        SignupApi signupApi=new SignupApi();
        String userName="demouser"+new FakerUtils().generateRandomNumber();
        User user=new User().
                setUsername(userName).
                setPassword("demopwd").
                setEmail(userName+"@gmail.com");

        signupApi.registerUser(user);

        //Add to cart using API

        AddToCartApi addToCartApi=new AddToCartApi(signupApi.getCookies());

        addToCartApi.addToCart(1198,1);

        injectCookiesToBrowser(addToCartApi.getCookies());

        //Application state is now ready lets open browser

                OrderConfirmationPage orderConfirmationPage=checkOutPage.load().
                                                            setBillingAddress(billingAddress).
                                                            clickOnCashOnDelivery().
                                                            clickPlaceOrderButton();
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationText(),
                "Thank you. Your order has been received.");
    }
}
