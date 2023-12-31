package com.example.demo;

public class Product {

    public int serialNumber;
    public String name;

    public String vendor;

    public String category;
    public double price;
    public int quantity;

    public Product(int serialNumber, String name,String vendor,String cat, double price, int quantity) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.category = cat;
        this.price = price;
        this.quantity = quantity;
    }
}
