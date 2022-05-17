package org.selenium.pom.Utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    private ConfigLoader(){
        properties=PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }
    public static ConfigLoader getInstance(){
        if(configLoader==null){
            return new ConfigLoader();
        }
        return configLoader;
    }
    public String getBaseUrl(){
        String baseUrl=properties.getProperty("baseUrl");
        if(baseUrl!=null) return baseUrl;
         throw new RuntimeException("base url is null in config.properties");
    }
    public String getUserName(){
        String userName=properties.getProperty("username");
        if(userName!=null) return userName;
        throw new RuntimeException("userName is null in config.properties");
    }
    public String getPassword(){
        String password=properties.getProperty("password");
        if(password!=null) return password;
        throw new RuntimeException("password is null in config.properties");
    }
}
