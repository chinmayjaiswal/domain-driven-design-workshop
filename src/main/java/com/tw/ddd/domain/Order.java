package com.tw.ddd.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<CartItem> cartItems;


    public Order(Cart cart) {
        this.cartItems = new ArrayList<>(){
            {
                addAll(cart.getItems());
            }
        };
    }

    public Long calculateTotalAmount() {
        long total = 0L;
        for (CartItem item: cartItems) {
            total = total+item.getQuantity() * item.getProduct().getPrice().getAmount();
            total = total+ (item.getProduct().getWeight())/10 ;
        }
        return  total;
    }
}
