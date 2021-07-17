package com.tw.ddd.ecommerce;

import com.tw.ddd.domain.misc.Address;
import com.tw.ddd.domain.misc.Customer;
import com.tw.ddd.domain.misc.CustomerService;

public class BankApplicationDriver {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        displayCustomerInfo(customerService.getCustomerByName(CustomerService.customer1));

        customerService.updateAddress(CustomerService.customer1, new Address("Address 1"));
        displayCustomerInfo(customerService.getCustomerByName(CustomerService.customer1));
    }

    private static void displayCustomerInfo(Customer customer) {
        System.out.println(customer);
    }
}
