package com.homework;

/*
Given a number n, print n-th Fibonacci Number using Recursion. Create a Recursion Tree to support
your solution.
Examples:

Input  : n = 2
Output : 1

Input  : n = 9
Output : 34
 */
public class HW3Fibonacci {

    public void printFibonacci (int n) {
        System.out.println(findFibonacci(n));
    }

    int findFibonacci(int n){
        if(n<2)  return n;
        return findFibonacci(n-1)+ findFibonacci(n-2);
    }

}
