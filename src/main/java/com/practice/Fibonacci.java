package com.practice;

public class Fibonacci {

    private static int calcFibanacci(int n){
        if (n <2) return n;
        return calcFibanacci(n-2)+calcFibanacci(n-1);
    }
    public static void main (String [] args){

        System.out.println(calcFibanacci(7));
    }
}
