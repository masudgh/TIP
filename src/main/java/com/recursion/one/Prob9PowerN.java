package com.recursion.one;

public class Prob9PowerN {

    public int powerN(int base, int n) {
        if (n==0) return 1;
        return powerN(base, n-1)*base;
    }

}
