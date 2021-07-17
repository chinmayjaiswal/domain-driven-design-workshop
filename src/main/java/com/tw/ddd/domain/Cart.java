package com.tw.ddd.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {

    private final Set<CartItem> items;
    private final List<String> removedItemsLog;

    public Cart() {
        items = new HashSet<>();
        removedItemsLog = new ArrayList<String>();
    }

    public void addProduct(CartItem item) {
        this.items.add(item);
    }

    public  void removeItem(String name){
        removedItemsLog.add(name);
       items.remove(new CartItem(new Product(name)));
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public List<String> getRemovedItemsLog() {
        return removedItemsLog;
    }
}
