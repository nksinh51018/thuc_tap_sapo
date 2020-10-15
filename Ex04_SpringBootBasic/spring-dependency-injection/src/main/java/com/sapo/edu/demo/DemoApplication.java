package com.sapo.edu.demo;

import com.sapo.edu.demo.common.CustomerCommon;
import com.sapo.edu.demo.common.StringCommon;
import com.sapo.edu.demo.constant.Message;
import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.model.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    public static int NUM_CASE =4;

    @Autowired
    private Atm bidvAtm;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer = null;
        int c = -1;
        while (c != 0 ){
            renderUI();
            c = StringCommon.enterTheNumber(Message.ENTER_THE_NUMBER,Message.RE_ENTER_THE_NUMBER+Message.FROM);
            while (c < 0 || c>NUM_CASE){
                c = StringCommon.enterTheNumber(Message.ENTER_THE_NUMBER,Message.RE_ENTER_THE_NUMBER+Message.FROM);
            }
            renderMessage(c);
            switch (c){
                case 0:
                    break;
                case 1:
                    customer = onEnterCustomer(bidvAtm);
                    break;
                case 2:
                    customer = onDisplayCustomer(bidvAtm,customer);
                    break;
                case 3:
                    customer = onWithDraw(bidvAtm,customer);
                    break;
                case 4:
                    customer = onDeposit(bidvAtm,customer);
                    break;
                default:
                    System.out.println("No message");
                    break;
            }
            renderEndUI();

        }

    }

    // method handle when display customer
    private Customer onDisplayCustomer(Atm atm, Customer customer) {
        if(customer == null){
            customer = onEnterCustomer(atm);
        }
        else{
            atm.displayCustomerInfo(customer);
        }
        return  customer;
    }

    // render menu UI
    private void renderUI(){
        int t = 0;
        System.out.println("--------Atm--------");
        System.out.println(t++ + ". Exit");
        System.out.println(t++ + ". Enter the customer");
        System.out.println(t++ + ". Display customer");
        System.out.println(t++ + ". withDraw");
        System.out.println(t++ + ". deposit");
    }

    // render end UI
    private void renderEndUI(){
        System.out.println("Press Enter to continue!!!");
        scanner.nextLine();
    }

    // render message when choose a number in menu
    private void renderMessage(int c){
        switch (c){
            case 1:
                System.out.println("Enter the customer");
                break;
            case 2:
                System.out.println("With Draw");
                break;
            case 3:
                System.out.println("Deposit");
                break;
            default:
                System.out.println("No message");
                break;
        }
    }

    // method handle when enter a customer
    private Customer onEnterCustomer(Atm atm){
        Customer customer =  CustomerCommon.enterCustomer();
        atm.displayCustomerInfo(customer);
        return customer;
    }

    // method handle when withdraw
    private Customer onWithDraw(Atm atm,Customer customer){
        if(customer == null){
            customer = onEnterCustomer(atm);
        }
        int x = StringCommon.enterTheNumber("Enter the number to withdraw: ","Re-enter the number to withdraw: ");
        atm.withDraw(customer,new BigDecimal(x));
        atm.printCurrentMoney();
        return customer;
    }

    // method handle when deposit
    private Customer onDeposit(Atm atm,Customer customer){
        if(customer == null){
            customer = onEnterCustomer(atm);
        }
        int x = StringCommon.enterTheNumber("Enter the number to deposit: ","Re-enter the number to deposit: ");
        atm.deposit(customer,new BigDecimal(x));
        atm.printCurrentMoney();
        return customer;
    }

}
