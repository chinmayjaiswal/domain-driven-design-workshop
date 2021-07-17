package com.tw.ddd.domain.service;

import com.tw.ddd.domain.Price;

import java.util.HashMap;
import java.util.Map;

public class ProductPricingService {

    static Map<String, Price> map;

    static {
        map = new HashMap<>();
        map.put(ProductService.ipadProProductName, new Price(1000L));
        map.put(ProductService.heroInkPenProductName, new Price(10L));
        map.put(ProductService.gmCricketBatProductName, new Price(100L));
    }

    public static Price getCompetitorDiscountedPrice(String name) {
        long discountedAmount = map.get(name).getAmount() * 9;
        return new Price(discountedAmount/10);
    }
}
