package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.service.Printer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("PrinterFile")
public class PrinterFile implements Printer {

    @Value("${myApplication.fileName}")
    private String fileName;

    private File f;

    private File createFile(String fileName){
        File myObj = null;
        try {
            myObj = new File(fileName);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myObj;
    }

    @Override
    public void printCustomer(Customer customer) {

       String s = "CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString();
       if(f == null){
           f = createFile(fileName);
       }
       printMessage(s);

    }

    @Override
    public void printMessage(String message) {
        try {
            FileWriter myWriter = new FileWriter(fileName,true);
            myWriter.write(message+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
