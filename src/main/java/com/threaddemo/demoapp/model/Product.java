package com.threaddemo.demoapp.model;


public class Product {

    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
}
