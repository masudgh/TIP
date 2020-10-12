package com.homework.array;

import java.util.HashMap;
import java.util.Map;

/*

We're given a large array of 4-byte integers.We need to write a method to find out how many
total bits are turned on (i.e. 1s are set) inside such an array. [Such a digital sum of binary
representation of a number, is also called its Hamming Weight].
e.g.
1. if input array has two numbers: 31 and 51, the answer is 9, because 31 has 5 bits turned on
(out of 32) and 51 has 4.
2. if the input is 2147483647 and 3, the answer is 31 + 2 = 33
We're looking for a fast solution, even if it uses extra memory. While it is possible to optimize
solutions based on the machine architecture, we're not looking for intense bit-hackery.
Assume input in base-10. No floating points.
Hint: Think hash tables.
Solution: See the top solution here: http://stackoverflow.com/questions/8871204/countnumber-of-1s-in-binary-representation
Interview time: 25 minutes.

 */
public class HammingWeight {

    public static int bitCount(int n){
        int count =0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
       // System.out.println(count);
        return count;
    }
    public static void bitCount(int [] arr){
        int count = 0;


        for(int n: arr) {
           count+= bitCount(n);
        }
        System.out.println(count);

    }

    private static final int MAX_ARRAY_SIZE = (Integer.MAX_VALUE - 8);
    public static final int [] countLookUp = new int [MAX_ARRAY_SIZE];
    public static void bitCountHugeSpace(int [] arr){


        for(int i = 0; i <MAX_ARRAY_SIZE; i++){
            countLookUp[i] = bitCount(i);
        }
        int count = 0;
        for(int n: arr) {
            count+= countLookUp[n];
        }
        System.out.println(count);

    }


    public static void main (String [] args){
        //int [] arr ={2147483647,3};
        int [] arr ={3100,51444};
        bitCount(arr);
        bitCountHugeSpace(arr);
    }
}
