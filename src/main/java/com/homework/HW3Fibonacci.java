package com.homework;

public class HW3Fibonacci {

    public void printFibonacci (int n) {
        System.out.println(findFibonacci(n));
    }

    int findFibonacci(int n){
        if(n<2)  return n;
        return findFibonacci(n-1)+ findFibonacci(n-2);
    }

}
