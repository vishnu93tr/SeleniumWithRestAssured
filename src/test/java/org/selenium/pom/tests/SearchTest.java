package org.selenium.pom.tests;

import org.selenium.pom.Base.BaseTest;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchWithPartialText(){
        String searchFor="Blue";
        StorePage storePage=new StorePage(getDriver()).
                load().
                enterIntoSearchField(searchFor).
                clickOnSearchButton();
        Assert.assertTrue(storePage.getTitle().contains(searchFor));
    }
}
