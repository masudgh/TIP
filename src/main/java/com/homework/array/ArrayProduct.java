package com.homework.array;


import java.util.Arrays;

public class ArrayProduct {

    private static void calcProduct(int [] arr){
        int [] prod = new int [arr.length];
        for(int i=0; i< arr.length; i++){
            prod[i] = arr[i];
        }
        System.out.println(Arrays.toString(prod));
        for(int i=1; i< arr.length; i++){
            prod[i] = prod[i-1]*arr[i-1];
        }


        System.out.println(Arrays.toString(prod));

        int product =1;
        for(int i=arr.length-1; i>=0; i--){
            prod[i] = prod[i]*product;
            product = product * arr[i];
        }

        System.out.println(Arrays.toString(prod));
    }

    public static void main (String [] args){
        int [] arr = { 1,2,3,4,5};
        calcProduct(arr);
    }
}
