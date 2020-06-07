package com.java.assignment;

public class Sale {
    /*
    *   productName|price
    */
    private final String productName;
    private final int price;

    public Sale (String productName, int price){
        this.productName = productName;
        this.price = price;
    }

    public String getProductName(String productName){
        return productName;
    }

    public int getPrice(int price){
        return price;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
