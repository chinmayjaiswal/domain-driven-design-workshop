package com.tw.ddd.domain;

import java.util.Objects;

public class CartItem {
    private static final Integer DEFAULT_QUANITY = 1;
    private Product product;
    private Integer quantity;

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = DEFAULT_QUANITY;
    }
    public String getName(){
        return  this.product.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return product.getName().equals(cartItem.product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getName());
    }

    @Override
    public String
    toString() {
        return "CartItem{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
