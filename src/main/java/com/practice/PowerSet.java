package com.practice;

public class PowerSet {

    private static int [] arr = { 4, 5, 7, 8, 18};

    private static void printPowerSet(int [] arr){
        if(arr == null) System.out.println("{}");

        printPowerSet(arr,0, new int[0] );
    }

    private static void printResult(int[] result){
        System.out.print("{");
        for(int i: result){
            System.out.print(i + ", ");
        }
        System.out.print("}");
        System.out.println();

    }
    private static void printPowerSet(int [] arr, int i, int[] result){

        int n = arr.length;
        if (i == n) {
            printResult(result);
            return;
        }

        int [] newResult = new int [result.length+1];
        for(int j=0; j< result.length; j++){
            newResult[j] = result[j];
        }
        newResult[result.length]= arr[i];

        printPowerSet(arr,i+1,result);
        printPowerSet(arr,i+1,newResult);
    }

    public static void main (String [] args){
        printPowerSet(arr);
    }
}
