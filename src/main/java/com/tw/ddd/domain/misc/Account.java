package com.tw.ddd.domain.misc;

import java.math.BigDecimal;

public class Account {
    private String id;
    private BigDecimal balance;
    private  Address address;

    public Account(String id) {
        this.id = id;
        this.balance = BigDecimal.ZERO;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", address=" + address +
                '}';
    }
}
