package com.tw.ddd.ecommerce;

import com.tw.ddd.domain.Cart;
import com.tw.ddd.domain.CartItem;
import com.tw.ddd.domain.Price;
import com.tw.ddd.domain.Product;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final String ipadProProductName = "Ipad Pro";
    private static final String heroInkPenProductName = "Hero Ink Pen";
    private static final String gmCricketBatProductName = "GM Cricket bat";

    static Map<String, Price> map;

    static {
        map = new HashMap<>();
        map.put(ipadProProductName, new Price(1000L));
        map.put(heroInkPenProductName, new Price(10L));
        map.put(gmCricketBatProductName, new Price(100L));
    }

    public static void main(String[] args) {

        //already available products------- from system
        Product ipadProProduct = new Product(ipadProProductName, getCompetitorAdjustedPrice(ipadProProductName));

        Product heroInkPenProduct = new Product(heroInkPenProductName, getCompetitorAdjustedPrice(heroInkPenProductName));

        Product gmCricketBatProduct = new Product(gmCricketBatProductName, getCompetitorAdjustedPrice(gmCricketBatProductName));


        //------user interaction starts here
        Cart cart = new Cart("Cart-1");
        cart.addProduct(new CartItem(ipadProProduct));

        cart.addProduct(new CartItem(heroInkPenProduct));
        cart.addProduct(new CartItem(gmCricketBatProduct, 2));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

        cart.addProduct(new CartItem(ipadProProduct, 5));
        displayInformation(cart);

        cart.removeItem(ipadProProductName);
        displayInformation(cart);

        Cart cart2 = new Cart("Cart-2");
        cart2.addProduct(new CartItem(ipadProProduct, 2));
        cart2.addProduct(new CartItem(gmCricketBatProduct, 2));
        displayInformation(cart2);

    }

    public static Price getCompetitorAdjustedPrice(String name) {
        long discountedAmount = map.get(name).getAmount().longValue() * 9;
        return new Price(discountedAmount/10);
    }

    public static void displayInformation(Cart cart) {
        System.out.println(MessageFormat.format("\n----------Items In the {0}:--------", cart.getId()));
        cart.getItems().forEach(item -> System.out.println(item.toString()));

        System.out.println("Removed Items");
        System.out.println(cart.getRemovedItemsLog());
    }
}
