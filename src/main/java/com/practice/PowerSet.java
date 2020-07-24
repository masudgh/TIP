package com.practice;

public class PowerSet {

    private static int [] arr = { 4, 5, 7, 8, 18};

    private static void printPowerSet(int [] arr){
        if(arr == null) System.out.println("{}");

        printPowerSet(arr,0, new int[0] );
    }

    private static void printPowerSet(int [] arr, int i, int[] result){

      //  if(i == result.)

    }

    public static void main (String [] args){
        printPowerSet(arr);
    }
}
