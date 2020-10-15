package com.sapo.edu.demo.common;

import com.sapo.edu.demo.model.Customer;

import java.math.BigDecimal;

public class CustomerCommon {

    // Enter the customer
    public static Customer enterCustomer(){
        Customer customer = new Customer();
        customer.setAcctNo(StringCommon.enterTheString("Enter the Acct No: "));
        customer.setPin(StringCommon.enterTheString("Enter the pin: "));
        int balance = StringCommon.enterTheNumber("Enter the balance","Re-enter the balance ( a number): ");
        customer.setBalance(new BigDecimal(balance));
        return customer;
    }

}
