package org.selenium.pom.Base;

import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.Utils.CookieUtils;
import org.selenium.pom.constants.BrowserType;
import org.selenium.pom.factory.DriverManagerCopy;
import org.selenium.pom.factory.DriverManagerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class BaseTest {
    protected ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    protected WebDriver getDriver(){
        return driver.get();
    }
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser){
        browser=System.getProperty("browser","CHROME");
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).initializeDriver());
    }
    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(ITestResult result,@Optional String browser) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            File destFile=new File("screenshots"+File.separator+browser+File.separator+
                    result.getTestClass().getRealClass().getSimpleName()
                    +"_"+result.getMethod().getMethodName()+".png");
            getScreenshot(destFile);
        }
        getDriver().quit();
    }
    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies= new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie ref:seleniumCookies){
            getDriver().manage().addCookie(ref);
        }
    }
    private void getScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) getDriver();
        File scrFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,destFile);
    }
}
