package com.tw.ddd.domain.service;

import com.tw.ddd.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    public static final String ipadProProductName = "Ipad Pro";
    public static final String heroInkPenProductName = "Hero Ink Pen";
    public static final String gmCricketBatProductName = "GM Cricket bat";

    Product ipadProProduct = new Product(ProductService.ipadProProductName, ProductPricingService.getCompetitorDiscountedPrice(ProductService.ipadProProductName));

    Product heroInkPenProduct = new Product(ProductService.heroInkPenProductName,  ProductPricingService.getCompetitorDiscountedPrice(ProductService.heroInkPenProductName));

    Product gmCricketBatProduct = new Product(ProductService.gmCricketBatProductName,  ProductPricingService.getCompetitorDiscountedPrice(ProductService.gmCricketBatProductName));

    Map<String,Product> productMap = new HashMap<>(){
        {
            put(ipadProProductName,ipadProProduct);
            put(heroInkPenProductName,heroInkPenProduct);
            put(gmCricketBatProductName,gmCricketBatProduct);
        }
    };
    public  Product getProductByName(String productName){
        return productMap.get(productName);
    }
}
