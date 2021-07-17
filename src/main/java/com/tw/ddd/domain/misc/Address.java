package com.tw.ddd.domain.misc;

public class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
