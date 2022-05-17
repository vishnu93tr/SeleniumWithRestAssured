package org.selenium.pom.Utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<Cookie> seleniumCookies=new ArrayList<>();
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies=cookies.asList();
        for(io.restassured.http.Cookie ref:restAssuredCookies){
            seleniumCookies.add(new Cookie(ref.getName(),
                    ref.getValue(),
                    ref.getDomain(),ref.getPath(),
                    ref.getExpiryDate(),ref.isSecured(),
                    ref.isHttpOnly(),ref.getSameSite()));
        }
        return seleniumCookies;
    }
}
