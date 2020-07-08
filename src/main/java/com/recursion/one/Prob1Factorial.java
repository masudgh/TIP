package com.recursion.one;

public class Prob1Factorial {
    public int factorial(int n) {
        if (n ==0 ) return 0;
        if ( n ==1 ) return n;
        return factorial(n-1)*n;

    }

}
