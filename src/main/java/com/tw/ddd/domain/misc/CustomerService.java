package com.tw.ddd.domain.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    public static final String customer1 = "Customer1";
    public static final String customer2 = "Customer2";
    public static final String customer3 = "Customer3";

    Map<String, Customer> customerMap = new HashMap<>() {
        {
            put(customer1, new Customer(customer1));
            put(customer2, new Customer(customer2));
            put(customer3, new Customer(customer3));
        }
    };


    public Customer getCustomerByName(String customerName) {
        return customerMap.get(customerName);
    }
    public void updateCustomerMap(Customer customer)
    {
        customerMap.put(customer.getName(),customer);
    }
    public void updateAddress(String customerName,Address newAddress){
        Customer customer = getCustomerByName(customerName);
        customer.setAddress(newAddress);
        customer.getAccounts().forEach(account -> account.setAddress(newAddress));
        updateCustomerMap(customer);

    }
}
