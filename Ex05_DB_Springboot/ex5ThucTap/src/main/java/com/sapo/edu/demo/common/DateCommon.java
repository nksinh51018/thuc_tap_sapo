package com.sapo.edu.demo.common;

import com.sapo.edu.demo.DemoApplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateCommon {

    public static final  Scanner scanner = new Scanner(System.in);
    public static final String PATTERN = "dd-MM-yyyy";
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);

    // Enter the date from console
    public static Date enterTheDate(String mess){
        String strDate ;
        Date date = null;
        while (date == null){
            try{
                strDate = scanner.nextLine();
                date = simpleDateFormat.parse(strDate);
            }
            catch (Exception e){
                System.out.println(mess + " format "+PATTERN);
                date=null;
            }
        }
        return date;
    }

}
