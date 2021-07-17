package com.tw.ddd.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private String id;
    private String status;

    private final Set<CartItem> items;
    private final List<String> removedItemsLog;

    public Cart(String id) {
        this.id = id;
        items = new HashSet<>();
        removedItemsLog = new ArrayList<>();
    }

    public void addProduct(CartItem item) {
        System.out.println("Adding Item "+ item.getProduct().getName() + "  "+ item.getProduct().getPrice() + " Quantity: " + item.getQuantity());
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

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order checkout(){
        this.status = "Checked-Out";
        return new Order(this);
    }
}
