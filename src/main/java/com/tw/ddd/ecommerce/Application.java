package com.tw.ddd.ecommerce;

import com.tw.ddd.domain.Cart;
import com.tw.ddd.domain.CartItem;
import com.tw.ddd.domain.Product;

public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();
        String ipadProProductName = "Ipad Pro";
        cart.addProduct(new CartItem(new Product(ipadProProductName)));
        cart.addProduct(new CartItem(new Product("Hero Ink Pen")));
        cart.addProduct(new CartItem(new Product("GM Cricket bat"), 2));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

        cart.addProduct(new CartItem(new Product(ipadProProductName),5));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

    }

    public static void displayInformation(Cart cart) {
        System.out.println("\n----------Items In the Cart:--------");
        cart.getItems().forEach(item -> System.out.println(item.toString()));

        System.out.println("Removed Items");
        System.out.println(cart.getRemovedItemsLog());
    }
}
