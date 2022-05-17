package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.DataProviders.MyDataProviders;
import org.selenium.pom.Utils.FakerUtils;
import org.selenium.pom.api.actions.AddToCartApi;
import org.selenium.pom.api.actions.SignupApi;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.AccountPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {
    @Test(dataProvider = "getBillingInfo",dataProviderClass = MyDataProviders.class)
    public void checkMyOrderUsingLogin(BillingAddress billingAddress){
        CheckOutPage checkOutPage=new CheckOutPage(getDriver()).load();

        SignupApi signupApi=new SignupApi();

        String userName="demouser"+ new FakerUtils().generateRandomNumber();
        User user=new User().
                setUsername(userName).
                setPassword("demopwd").
                setEmail(userName+"@gmail.com");

        signupApi.registerUser(user);

        AddToCartApi addToCartApi=new AddToCartApi(signupApi.getCookies());

        addToCartApi.addToCart(1198,1);

        injectCookiesToBrowser(signupApi.getCookies());

        OrderConfirmationPage orderConfirmationPage=checkOutPage.
                load().
                setBillingAddress(billingAddress).
                clickOnDirectBankTransfer().
                clickPlaceOrderButton();
        String orderNumberFromConfirmationPage=orderConfirmationPage.getOrderNumber();
        AccountPage accountPage=new AccountPage(getDriver()).load();
        String orderNumberFromAccountsPage=accountPage.clickOnOrders().getOrderNumber().replace("#","");
        Assert.assertEquals(orderNumberFromConfirmationPage,orderNumberFromAccountsPage);
    }
}
