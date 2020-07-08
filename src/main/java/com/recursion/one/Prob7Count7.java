package com.recursion.one;

public class Prob7Count7 {
    public int count7(int n) {
        if( n <= 0 ) return 0;
        int count = 0;
        int rightDigit = n%10;
        if ( rightDigit == 7)  count ++;
        int left = n /10;

        return count7(left)+count;
    }

}
