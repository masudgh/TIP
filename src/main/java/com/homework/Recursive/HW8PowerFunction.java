package com.homework.Recursive;

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

    public double  powBrut (double base, int exp){
        if(exp ==0) return 1;
        if(exp ==1) return base;
        if(exp ==2) return base*base;

        if(exp>0)
            return powBrut ( base,  exp-1)* base;
        else
            return 1/(powBrut ( base,  -exp-1)* base);
    }


    public double powOptimize(double base, int exp){
        if(exp ==0) return 1;
        if(exp ==1) return base;

        double powerVal = powOptimize(base, exp/2);

        if(exp%2==0) {
            if(exp>0)
                return powerVal*powerVal;
            else
                return 1/(powerVal*powerVal);
        }

        else{
            if(exp>0)
                return base*powerVal*powerVal;
            else
                return 1/(base*powerVal*powerVal);
        }

    }


}
