package com.sapo.edu.demo.ultis;

import com.sapo.edu.demo.constants.Message;
import com.sapo.edu.demo.constants.MessageStringUltis;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class StringUltis {

    public static final Scanner scanner = new Scanner(System.in);
    // enter the number
    public static int enterTheNumber1(){
        return enterTheNumber(Message.RE_ENTER_THE_NUMBER+" "+Message.FROM);
    }

    public static int enterTheNumber(){
        return enterTheNumber(Message.RE_ENTER_THE_NUMBER);
    }

    public static int enterTheNumber(String s){
        int x = -1;
        boolean check = true;
        System.out.println(Message.ENTER_THE_NUMBER);
        try{
            x = scanner.nextInt();
            check = false;
        }
        catch (Exception e) {
            System.out.println(s);
        }
        while (check){
            try{
                scanner.nextLine();
                x = scanner.nextInt();
                check = false;
            }
            catch (Exception e) {
                System.out.println(s);
                check = true;
            }
        }
        return x;
    }

    // enter the string
    public static String enterTheString(){
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

    // Checks if the CharSequence contains any character in the given set of characters
    public static void containsAny(String a, String b){
        boolean contained = StringUtils.containsAny(a,b);
        if(contained){
            System.out.println(MessageStringUltis.CONTAINS_ANY_MESSAGE);
        }
        else{
            System.out.println(MessageStringUltis.NO_CONTAINS_ANY_MESSAGE);
        }
    }

    // Checks if the CharSequence contains any character in the given set of characters irrespective of case
    public static void containsIgnoreCase(String a, String b){
        boolean contained = StringUtils.containsIgnoreCase(a,b);
        if(contained){
            System.out.println(MessageStringUltis.CONTAINS_IGNORE_CASE_MESSAGE);
        }
        else{
            System.out.println(MessageStringUltis.NO_CONTAINS_IGNORE_CASE_MESSAGE);
        }
    }

    // Counts how many times the substring appears in the larger string
    public static void countMatches(String a, String b){
        int dem  = StringUtils.countMatches(a,b);
        System.out.println(MessageStringUltis.COUNT_MATCHES_MESSAGE+ dem);
    }

    // Appends the suffix to the end of the string if the string does not already end with any of the suffixes.
    public static void appendIfMissing(String a, String b){
        String s  = StringUtils.appendIfMissing(a,b);
        System.out.println(MessageStringUltis.APPEND_IF_MISSING_MESSAGE+s);
    }

    //Prepends the prefix to the start of the string if the string does not already start with any of the prefixes.
    public static void prependIfMissing(String a, String b){
        String s  = StringUtils.prependIfMissing(a,b);
        System.out.println(MessageStringUltis.PREPEND_IF_MISSING_MESSAGE+s);
    }

    // Converts all of the characters in string to upper case
    public static void toUpperCase(String... arr){
        for (String s : arr) {
            s = s.toUpperCase();
            System.out.println(MessageStringUltis.NEW_STRING+s);
        }
    }

    // Converts all of the characters in string to lower case
    public static void toLowerCase(String... arr){
        for (String s : arr) {
            s = s.toLowerCase();
            System.out.println(MessageStringUltis.NEW_STRING+s);
        }
    }



}
