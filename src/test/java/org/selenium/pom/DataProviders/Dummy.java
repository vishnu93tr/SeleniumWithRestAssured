package org.selenium.pom.DataProviders;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Dummy {
    public static void main(String[] args) throws IOException, ParseException {
        MyDataProviders myDataProviders=new MyDataProviders();
        Object[] obj=myDataProviders.getCoupons();
        for(Object ref:obj){
            System.out.println(ref);
        }
    }
}
