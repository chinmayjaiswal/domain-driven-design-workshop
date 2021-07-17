package com.tw.ddd.domain;

import java.util.Currency;

public class Price {

    private Long amount;
    private Currency currency;

    public Price(Long amount) {
        this.amount = amount;
        this.currency = Currency.getInstance("INR");
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount +" " + currency.getCurrencyCode();
    }
}
