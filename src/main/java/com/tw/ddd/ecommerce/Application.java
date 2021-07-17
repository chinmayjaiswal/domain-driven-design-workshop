package com.tw.ddd.ecommerce;

import com.tw.ddd.domain.Cart;
import com.tw.ddd.domain.CartItem;
import com.tw.ddd.domain.Price;
import com.tw.ddd.domain.Product;

import java.text.MessageFormat;

public class Application {
    public static void main(String[] args) {

        //already available products------- from system
        String ipadProProductName = "Ipad Pro";
        Product ipadProProduct = new Product(ipadProProductName, new Price(1000L));
        Product heroInkPenProduct = new Product("Hero Ink Pen",new Price(10L));
        Product gmCricketBatProduct = new Product("GM Cricket bat",new Price(100L));


        //------user interaction starts here
        Cart cart = new Cart("Cart-1");
        cart.addProduct(new CartItem(ipadProProduct));

        cart.addProduct(new CartItem(heroInkPenProduct));
        cart.addProduct(new CartItem(gmCricketBatProduct, 2));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

        cart.addProduct(new CartItem(ipadProProduct,5));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

        Cart cart2 = new Cart("Cart-2");
        cart2.addProduct(new CartItem(ipadProProduct,2));
        cart2.addProduct(new CartItem(gmCricketBatProduct,2));
        displayInformation(cart2);

    }

    public static void displayInformation(Cart cart) {
        System.out.println(MessageFormat.format("----------Items In the {0}:--------",cart.getId()) );
        cart.getItems().forEach(item -> System.out.println(item.toString()));

        System.out.println("Removed Items");
        System.out.println(cart.getRemovedItemsLog());
    }
}
