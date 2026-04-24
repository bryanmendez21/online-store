package com.pluralsight;

public class Product {
    // Attributes
    private String sku;
    private String productName;
    private double price;
    private String department;

    // Constructor
    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    // sku setter and getter
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    // product name setter and getter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // price setter and getter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // department setter and getter
    public String getDepartment() {
        return department;
    }

    public void setCategory(String department) {
        this.department = department;
    }
}
