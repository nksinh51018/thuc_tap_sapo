package com.sapo.edu.demo.ultis;

import com.sapo.edu.demo.DemoApplication;
import com.sapo.edu.demo.constants.MessageDateUltis;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUltis {

    public static final  Scanner scanner = new Scanner(System.in);

    // Enter the date from console
    public static Date enterTheDate(){
        SimpleDateFormat simpleDateFormat = DemoApplication.SIMPLEDATEFORMAT;
        String strDate = scanner.nextLine();
        Date date = null;
        try{
            date = simpleDateFormat.parse(strDate);
        }
        catch (Exception e){
            date=null;
        }
        return date;
    }

    // Checks if two date objects are on the same day ignoring time
    public static void isSameDay(Date date1, Date date2){
        if(date1 ==null || date2 ==null){
            System.out.println(MessageDateUltis.ERROR_FORMAT);
            return;
        }
        boolean checkDay = DateUtils.isSameDay(date1,date2);
        if(checkDay){
            System.out.println(MessageDateUltis.DATE_SAME);
        }
        else{
            System.out.println(MessageDateUltis.DATE_NOT_SAME);
        }
    }

    // Check if today is in range two date
    public static void isTodayInRange(Date date1, Date date2){
        if(date1 ==null || date2 ==null){
            System.out.println(MessageDateUltis.ERROR_FORMAT);
            return;
        }
        Date today = Calendar.getInstance().getTime();
        boolean checkDay = true;
        if (date1.after(today) && date2.after(today)) {
            checkDay = false;
        }

        if (date1.before(today) && date2.before(today)) {
            checkDay = false;
        }
        if(checkDay){
            System.out.println(MessageDateUltis.TODAY_RANGE);
        }
        else{
            System.out.println(MessageDateUltis.TODAY_NOT_RANGE);
        }
    }
}
