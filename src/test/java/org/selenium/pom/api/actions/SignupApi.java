package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.selenium.pom.Utils.ConfigLoader;
import org.selenium.pom.objects.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SignupApi {
    private Cookies cookies;
    public Cookies getCookies(){
        return cookies;
    }
    private String getNonCeValue(){
        Response response=getAccount();
        Document document= Jsoup.parse(response.body().prettyPrint());
        return document.selectFirst("#woocommerce-register-nonce").attr("value");
    }
    private Response getAccount(){
     Cookies cookies=new Cookies();
    Response response= given().
                            baseUri(ConfigLoader.getInstance().getBaseUrl()).
                            cookies(cookies).
                        when().
                            get("/account").
                        then().
                            extract().response();
    return response;
    }
    public Response registerUser(User user){
        Cookies cookies=new Cookies();
        Map<String,String> formParams=new HashMap<>();
        formParams.put("username",user.getUsername());
        formParams.put("password",user.getPassword());
        formParams.put("email",user.getEmail());
        formParams.put("woocommerce-register-nonce",getNonCeValue());
        formParams.put("register","Register");
        Header header=new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        Response response= given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                when().
                post("/account").
                then().
                extract().response();
        this.cookies=response.getDetailedCookies();
        return response;
    }
}
