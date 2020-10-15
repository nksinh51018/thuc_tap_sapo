package com.sapo.edu.demo.model;

import com.sapo.edu.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface Atm {

    // withdraw money from atm
    void withDraw(Customer customer, BigDecimal amount);

    // print current money
    void printCurrentMoney();

    // deposit money
    void deposit(Customer customer, BigDecimal amount);

    // display customer info
    void displayCustomerInfo(Customer customer);
}
