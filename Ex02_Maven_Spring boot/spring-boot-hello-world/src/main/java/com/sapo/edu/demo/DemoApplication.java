package com.sapo.edu.demo;

import com.sapo.edu.demo.constants.*;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static final String PATTERN = "dd-MM-yyyy";
	public static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat(PATTERN);
	public static final int NUM_CASE = 16;
	public static final int NUM_CASE_STRING = 8;
	public static final int NUM_CASE_DATE = 10;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		Scanner scanner = new Scanner(System.in);
		int c= -1;
		int[] arr = {};

		while (c !=0){
			c=-1;
			renderUI();
			while ( c<0 || c>NUM_CASE){
				c= com.sapo.edu.demo.ultis.StringUltis.enterTheNumber1();
			}
			if(c==0){
				System.exit(0);
			}
			TwoString twoString = new TwoString();
			TwoDate twoDate = new TwoDate();
			stopWatch.reset();
			stopWatch.start();
			renderMessageStringAndDate(c);
			if(c<NUM_CASE_STRING){
				enterTwoString(twoString);
			}
			else if(c<NUM_CASE_DATE){
				enterTwoDate(twoDate);
			}

			switch (c){
				case  1:{
					com.sapo.edu.demo.ultis.StringUltis.containsAny(twoString.a,twoString.b);
					break;
				}
				case  2:{
					com.sapo.edu.demo.ultis.StringUltis.containsIgnoreCase(twoString.a,twoString.b);
					break;
				}
				case  3:{
					com.sapo.edu.demo.ultis.StringUltis.countMatches(twoString.a,twoString.b);
					break;
				}
				case  4:{
					com.sapo.edu.demo.ultis.StringUltis.appendIfMissing(twoString.a,twoString.b);
					break;
				}
				case  5:{
					com.sapo.edu.demo.ultis.StringUltis.prependIfMissing(twoString.a,twoString.b);
					break;
				}
				case  6:{
					com.sapo.edu.demo.ultis.StringUltis.toUpperCase(twoString.a,twoString.b);
					break;
				}
				case  7:{
					com.sapo.edu.demo.ultis.StringUltis.toLowerCase(twoString.a,twoString.b);
					break;
				}
				case  8:{
					com.sapo.edu.demo.ultis.DateUltis.isSameDay(twoDate.date1,twoDate.date2);
					break;
				}
				case  9:{
					com.sapo.edu.demo.ultis.DateUltis.isTodayInRange(twoDate.date1,twoDate.date2);
					break;
				}
				case  10:{
					arr = com.sapo.edu.demo.ultis.ArrayUltis.add(arr);
					break;
				}
				case  11:{
					arr = com.sapo.edu.demo.ultis.ArrayUltis.remove(arr);
					break;
				}
				case  12:{
					com.sapo.edu.demo.ultis.ArrayUltis.showAll(arr);
					break;
				}
				case  13:{
					com.sapo.edu.demo.ultis.ArrayUltis.contains(arr);
					break;
				}
				case  14:{
					com.sapo.edu.demo.ultis.ArrayUltis.reverse(arr);
					break;
				}
				case  15:{
					com.sapo.edu.demo.ultis.ArrayUltis.shift(arr);
					break;
				}
				case  16:{
					arr = com.sapo.edu.demo.ultis.ArrayUltis.subArray(arr);
					break;
				}
				default:{
					System.out.println(Message.RE_ENTER_THE_NUMBER);
				}
			}
			stopWatch.stop();
			renderEnd(stopWatch);
			scanner.nextLine();
		}

	}

	private void renderUI(){
		// UI
		int t=0;
		System.out.println(Message.CHOOSE_A_NUMBER);
		System.out.println(t++ +". " + Message.EXIT);
		System.out.println(MessageStringUltis.STRING_ULTIS);
		System.out.println(t++ +". " + MessageStringUltis.CONTAINS_ANY);
		System.out.println(t++ +". " + MessageStringUltis.CONTAINS_IGNORE_CASE);
		System.out.println(t++ +". " + MessageStringUltis.COUNT_MATCHES);
		System.out.println(t++ +". " + MessageStringUltis.APPEND_IF_MISSING);
		System.out.println(t++ +". " + MessageStringUltis.PREPEND_IF_MISSING);
		System.out.println(t++ +". " + MessageStringUltis.UPPERCASE);
		System.out.println(t++ +". " + MessageStringUltis.LOWERCASE);
		System.out.println(MessageDateUltis.DATE_ULTIS);
		System.out.println(t++ +". " + MessageDateUltis.IS_SAME_DAY);
		System.out.println(t++ +". " + MessageDateUltis.IS_TODAY_IN_RANGE);
		System.out.println(MessageArrayUltis.ARRAY_UTILS);
		System.out.println(t++ +". " + MessageArrayUltis.ADD);
		System.out.println(t++ +". " + MessageArrayUltis.REMOVE);
		System.out.println(t++ +". " + MessageArrayUltis.SHOW_ALL);
		System.out.println(t++ +". " + MessageArrayUltis.CONTAINS);
		System.out.println(t++ +". " + MessageArrayUltis.REVERSE);
		System.out.println(t++ +". " + MessageArrayUltis.SHIFT);
		System.out.println(t++ +". " + MessageArrayUltis.SUB_ARRAY);
	}

	private void renderEnd(StopWatch stopWatch){
		System.out.println(MessageStopwatchUltis.TIME + ((float)stopWatch.getTime())/1000+"s");
		System.out.print(Message.CONTINUE);
	}

	private void renderMessageStringAndDate(int c){
		switch (c) {
			case 1: {
				System.out.println("Checks if the CharSequence contains any character in the given set of characters");
				break;
			}
			case 2: {
				System.out.println("Checks if the CharSequence contains any character in the given set of characters irrespective of case");
				break;
			}
			case 3: {
				System.out.println("Counts how many times the substring appears in the larger string");
				break;
			}
			case 4: {
				System.out.println("Appends the suffix to the end of the string if the string does not already end with any of the suffixes.");
				break;
			}
			case 5: {
				System.out.println("Prepends the prefix to the start of the string if the string does not already start with any of the prefixes.");
				break;
			}
			case 6: {
				System.out.println("Converts all of the characters in string to upper case");
				break;
			}
			case 7: {
				System.out.println("Converts all of the characters in string to lower case");
				break;
			}
			case 8: {
				System.out.println("Checks if two date objects are on the same day ignoring time");
				break;
			}
			case 9: {
				System.out.println("Check if today is in range two date");
				break;
			}
			default:
				System.out.print("");
		}
	}


	private void enterTwoString(TwoString twoString){
		System.out.println(MessageStringUltis.ENTER_THE_TEXT_A);
		twoString.a = com.sapo.edu.demo.ultis.StringUltis.enterTheString();
		System.out.println(MessageStringUltis.ENTER_THE_TEXT_B);
		twoString.b= com.sapo.edu.demo.ultis.StringUltis.enterTheString();
	}

	private void enterTwoDate(TwoDate twoDate){
		System.out.println(MessageDateUltis.DATE_FORMAT);
		System.out.println(MessageDateUltis.ENTER_THE_DATE_A);
		twoDate.date1 = com.sapo.edu.demo.ultis.DateUltis.enterTheDate();
		System.out.println(MessageDateUltis.ENTER_THE_DATE_B);
		twoDate.date2 = com.sapo.edu.demo.ultis.DateUltis.enterTheDate();
	}


	private class TwoString{
		public String a;
		public String b;
	}

	private class TwoDate{
		public Date date1;
		public Date date2;
	}


}
