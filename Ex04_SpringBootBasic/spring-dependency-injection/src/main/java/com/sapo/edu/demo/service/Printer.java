package com.sapo.edu.demo.service;

import com.sapo.edu.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public interface Printer {
    // print customer
    void printCustomer(Customer customer);

    // print message
    void printMessage(String message);
}
