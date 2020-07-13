package com.homework;

/*
Implement a power function to raise a double to an int power, including negative powers.
e.g. pow(double d, int p) should give 'd' raised to power 'p'.
Of course, please don't use in-built methods like pow(). Idea is to implement that using
recursion.

Solution: http://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-aninteger-
based-power-function-powint-int
Can you do it in O(log n)
Suggested time: 10 minutes to do a brute-force and 15 with a trick that optimizes it.
 */

public class HW8PowerFunction {

    double  powBrut (double base, int exp){
        if(exp ==0) return 1;
        if(exp ==1) return base;
        if(exp ==2) return base*base;

        if(exp>0)
            return powBrut ( base,  exp-1)* base;
        else
            return 1/(powBrut ( base,  -exp-1)* base);
    }


   /* double  pow (double base, int exp){
        if(exp ==0) return 1;
        if(exp ==1) return base;
        if(exp ==2) return base*base;

        int n = exp/2;
        pow ( base,  exp,  n);

    }

    double  pow (double base, int exp, int n) {




        if(exp>0)
            return powBrut ( base,  exp-1)* base;
        else
            return 1/(powBrut ( base,  -exp-1)* base);

    }*/
}
