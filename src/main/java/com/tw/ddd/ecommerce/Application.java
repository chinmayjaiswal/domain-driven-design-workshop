package com.tw.ddd.ecommerce;

import com.tw.ddd.domain.Cart;
import com.tw.ddd.domain.CartItem;
import com.tw.ddd.domain.Order;
import com.tw.ddd.domain.Product;
import com.tw.ddd.domain.service.ProductService;

import java.text.MessageFormat;

public class Application {


    public static void main(String[] args) {
    ProductService productService = new ProductService();
        //already available products------- from system
        Product ipadProProduct = productService.getProductByName(ProductService.ipadProProductName);

        Product heroInkPenProduct = productService.getProductByName(ProductService.heroInkPenProductName);

        Product gmCricketBatProduct = productService.getProductByName(ProductService.gmCricketBatProductName);


        //------user interaction starts here
        Cart cart = new Cart("Cart-1");
        cart.addProduct(new CartItem(ipadProProduct));

        cart.addProduct(new CartItem(heroInkPenProduct));
        cart.addProduct(new CartItem(gmCricketBatProduct, 2));
        displayInformation(cart);

        cart.removeItem(ProductService.ipadProProductName);
        displayInformation(cart);

        cart.addProduct(new CartItem(ipadProProduct, 5));
        displayInformation(cart);

        cart.removeItem(ProductService.ipadProProductName);
        displayInformation(cart);

        Order order = cart.checkout();
        Long totalAMount = order.calculateTotalAmount();
        System.out.println(" Cart-1 total Amount:" + totalAMount);

        Cart cart2 = new Cart("Cart-2");
        cart2.addProduct(new CartItem(ipadProProduct, 2));
        cart2.addProduct(new CartItem(gmCricketBatProduct, 2));
        displayInformation(cart2);
        Order order2 = cart.checkout();
        Long totalAMount2 = order.calculateTotalAmount();
        System.out.println(" Cart-1 total Amount:" + totalAMount2);

    }


    public static void displayInformation(Cart cart) {
        System.out.println(MessageFormat.format("\n----------Items In the {0}:--------", cart.getId()));
        cart.getItems().forEach(item -> System.out.println(item.toString()));

        System.out.println("Removed Items");
        System.out.println(cart.getRemovedItemsLog());
    }
}
