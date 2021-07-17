package com.tw.ddd.domain.misc;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Account> accounts;
    private Address address;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>(){
            {
                add(new Account("SAVINGS"));
            }
        };
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                ", address=" + address +
                '}';
    }
}
