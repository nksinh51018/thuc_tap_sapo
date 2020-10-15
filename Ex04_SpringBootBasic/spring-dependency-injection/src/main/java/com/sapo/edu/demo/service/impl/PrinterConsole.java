package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.service.Printer;
import org.springframework.stereotype.Component;

@Component("PrinterConsole")
public class PrinterConsole implements Printer {

    // print customer
    @Override
    public void printCustomer(Customer customer) {
        System.out.println("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    // print message
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
