package org.selenium.pom.DataProviders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.selenium.pom.Utils.JacksonUtil;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Coupon;
import org.selenium.pom.objects.Product;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviders {
    @DataProvider(name = "getFeaturedProducts")
    public Object[] getFeaturedProducts() throws IOException {
        Product[] obj= JacksonUtil.deserialize("Products.json",Product[].class);
        List<Product> list=new ArrayList<>();
        for(Product product:obj){
            if(product.getisFeatured()){
                Product product1=new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                list.add(product1);
            }
        }
        return list.toArray();
    }
    @DataProvider(name = "getBillingInfo")
    public Object[] enterBillingDetails() throws IOException {
        BillingAddress[] obj=JacksonUtil.deserialize("BillingAddress.json", BillingAddress[].class);
        List<BillingAddress> list=new ArrayList<>();
        for(BillingAddress address:obj){
            list.add(address);
        }
        return list.toArray();
    }
    @DataProvider(name="getStoreProducts")
    public Object[] getStoreProducts() throws IOException {
        Product[] obj= JacksonUtil.deserialize("Products.json",Product[].class);
        List<Product> list=new ArrayList<>();
        for(Product product:obj){
            if(product.isInStore()){
                Product product1=new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                list.add(product1);
            }
        }
        return list.toArray();
    }
    @DataProvider(name = "getCoupons")
    public Object[] getCoupons() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        File file=new File("src/test/resources/Coupons.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        JSONArray jsonArray = (JSONArray) jsonObject.get("coupons");
        Iterator<String> iterator =jsonArray.iterator();
        List<String> list=new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list.toArray();
    }
}
