package com.recursion.one;

public class Prob3Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int val = fibonacci( n-2) + fibonacci( n-1);
        return val;
    }
}
