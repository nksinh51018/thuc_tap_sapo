package com.sapo.edu.demo.common;

import org.springframework.util.StringUtils;

import java.util.Scanner;

public class StringCommon {

    public static Scanner scanner = new Scanner(System.in);
    // enter the number
//    public static int enterTheNumber1(){
//        return enterTheNumber(Message.RE_ENTER_THE_NUMBER+" "+Message.FROM);
//    }
//
//    public static int enterTheNumber(){
//        return enterTheNumber(Message.RE_ENTER_THE_NUMBER);
//    }

    // enter the number with message enter and re-enter
    public static int enterTheNumber(String mess1,String mess2){
        int x = -1;
        boolean check = true;
        System.out.println(mess1);
        try{
            x = scanner.nextInt();
            check = false;
        }
        catch (Exception e) {
            System.out.println(mess2);
        }
        while (check){
            try{
                scanner.nextLine();
                x = scanner.nextInt();
                check = false;
            }
            catch (Exception e) {
                System.out.println(mess2);
                check = true;
            }
        }
        return x;
    }

    // enter the string with message
    public static String enterTheString(String mess){
        System.out.println(mess);
        String s = scanner.nextLine();
        boolean check = true;
        if(!s.isEmpty()){
            check=false;
        }
        while (check){
            s = scanner.nextLine();
            if(!s.isEmpty()){
                check=false;
            }
        }
        return s;
    }
}
