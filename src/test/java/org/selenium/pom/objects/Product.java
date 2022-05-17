package org.selenium.pom.objects;

import org.selenium.pom.Utils.JacksonUtil;

import java.io.IOException;

public class Product {
    private int id;
    private String name;
    private boolean isFeatured;
    private boolean inStore;
    public boolean isInStore(){
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }


    public boolean getisFeatured() {
        return isFeatured;
    }




    public Product(){}



    public Product(int id) throws IOException {
        Product[] products=JacksonUtil.deserialize("Products.json", Product[].class);
        for(Product product:products){
            if(product.getId()==id){
                this.id=id;
                this.name=product.getName();
                this.isFeatured= product.getisFeatured();
                this.inStore=product.isInStore();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
