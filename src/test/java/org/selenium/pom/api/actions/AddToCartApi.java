package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.Utils.ConfigLoader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddToCartApi {
    private Cookies cookies;
    public AddToCartApi(){

    }
    public AddToCartApi(Cookies cookies){
        this.cookies=cookies;
    }
    public Cookies getCookies(){
        return cookies;
    }
    public Response addToCart(int productId,int quantity){
        Header header=new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        Map<String,Object> map=new HashMap<>();
        map.put("product_sku","");
        map.put("product_id",productId);
        map.put("quantity",quantity);
        if(cookies==null){
            cookies=new Cookies();
        }
        Response response=given().
                            baseUri(ConfigLoader.getInstance().getBaseUrl()).
                            headers(headers).
                            formParams(map).
                            cookies(cookies).
                            when().
                                post("/?wc-ajax=add_to_cart").
                            then().
                                extract().response();
       if(response.getStatusCode()!=200){
           throw new RuntimeException("not able to add to cart"+response.getStatusCode());
       }
       this.cookies=response.getDetailedCookies();
       return response;
    }
}
