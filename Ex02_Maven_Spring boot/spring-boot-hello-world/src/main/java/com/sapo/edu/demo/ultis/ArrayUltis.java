package com.sapo.edu.demo.ultis;

import com.sapo.edu.demo.constants.MessageArrayUltis;
import org.apache.commons.lang3.ArrayUtils;

public class ArrayUltis {
    // add element to array
    public static int[] add(int[] arr){
        System.out.println("Add element to array");
        if(arr.length<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {renderArr(arr);
        }
        int x = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();
        arr = ArrayUtils.addAll(arr, x);
        renderArr(arr);
        return arr;
    }

    // remove element to array
    public static int[] remove(int[] arr){
        System.out.println("Remove element to array");
        int n= arr.length;
        if(n<=0){
            System.out.println(MessageArrayUltis.EMPTY);
            return arr;
        }
        else {
            renderArr(arr);
        }
        int x = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();

        while (x < 1 || x > n){
            x = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();
        }
        arr = ArrayUtils.removeAll(arr, x-1);
        renderArr(arr);
        return arr;
    }

    //show all elements in array
    public static void showAll(int [] arr){
        System.out.println("show all elements in array");
        if(arr.length<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {
            renderArr(arr);
        }
    }

    // checks if the value is in the given array.
    public static void contains(int [] arr){
        System.out.println("Checks if the value is in the given array.");
        int n= arr.length;
        if(n<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {
            renderArr(arr);
        }
        int x = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();

        boolean contains = ArrayUtils.contains(arr, x);
        if(contains){
            System.out.println(MessageArrayUltis.CONTAINS_MESSAGE);
        }
        else{
            System.out.println(MessageArrayUltis.NO_CONTAINS_MESSAGE);
        }
    }

    //Reverses the order of the given array.
    public static void reverse(int [] arr){
        System.out.println("Reverses the order of the given array.");
        if(arr.length<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {
            ArrayUtils.reverse(arr);
            renderArr(arr);
        }
    }

    //Shifts the order of the given int array.
    public static void shift(int [] arr){
        System.out.println("Shifts the order of the given int array.");
        if(arr.length<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {
            ArrayUtils.shift(arr,1);
            renderArr(arr);
        }
    }

    //Produces a new array containing the elements between the start and end indices.
    public static int[] subArray(int [] arr){
        System.out.println("Produces a new array containing the elements between the start and end indices.");
        if(arr.length<=0){
            System.out.println(MessageArrayUltis.EMPTY);
        }
        else {
            renderArr(arr);
            int x = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();
            int y = com.sapo.edu.demo.ultis.StringUltis.enterTheNumber();
            arr = ArrayUtils.subarray(arr,x,y);
            renderArr(arr);
        }
        return arr;
    }

    // Show all element in array
    public static void renderArr(int [] arr){
        System.out.println(MessageArrayUltis.SHOW_ALL_ARRAY_MESSAGE);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
