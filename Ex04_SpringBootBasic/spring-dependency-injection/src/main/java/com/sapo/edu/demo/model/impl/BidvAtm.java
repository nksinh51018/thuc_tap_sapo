package com.sapo.edu.demo.model.impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.model.Atm;
import com.sapo.edu.demo.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BidvAtm implements Atm {

    private BigDecimal moneyAtm;

    @Autowired
    @Qualifier("PrinterConsole")
    private Printer printer;

    public BidvAtm(@Value("${myApplication.moneyAtm}") int atmMoney){
        moneyAtm = new BigDecimal(atmMoney);
    }

    // withdraw money from atm
    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printer.printMessage("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printer.printMessage("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm) >= 0) {
            printer.printMessage("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm = moneyAtm.subtract(amount);
    }

    // print current money
    @Override
    public void printCurrentMoney() {
        printer.printMessage("Current ATM money is " + moneyAtm.toString());
    }

    // deposit money
    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printer.printMessage("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm = moneyAtm.add(amount);
    }

    // display customer info
    @Override
    public void displayCustomerInfo(Customer customer) {
        printer.printCustomer(customer);
    }
}
