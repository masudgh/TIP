package com.recursion.one;

public class Prob8Count8 {
    public int count8(int n) {
        if( n <= 0 ) return 0;
        int count = 0;
        int rightDigit = n%10;
        if ( rightDigit == 8)  count ++;
        int left = n /10;
        int rightDigit2 = left%10;
        if ( rightDigit == 8 && rightDigit2 == 8)  count ++;
        return count8(left)+count;
    }

}
