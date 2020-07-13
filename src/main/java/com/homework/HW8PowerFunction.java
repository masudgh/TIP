package com.homework;

/*
mplement a power function to raise a double to an int power, including negative powers.
e.g. pow(double d, int p) should give 'd' raised to power 'p'.
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
