package com.tw.ddd.domain;

public class Product {
    private final String name;
    private final Price price;

    public Product(String name,Price price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
        this.price = new Price(0L);
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
