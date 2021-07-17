package com.tw.ddd.domain;

public class Product {
    private final String name;
    private final Price price;
    private Integer weight;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
        this.weight = 10; //some default weight
    }

    public Product(String name) {
        this.name = name;
        this.price = new Price(0L);
    }

    public Integer getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
