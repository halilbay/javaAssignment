package com.java.assignment;

public class Sale {
    /*
    *   productName|price
    */
    private String productName;
    private int price;

    public Sale(String productName){
        this.productName = productName;
    }
    public Sale (String productName, int price){
        this(productName);
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
