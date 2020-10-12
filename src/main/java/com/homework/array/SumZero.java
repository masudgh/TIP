package com.homework.array;

import java.util.*;

/*
Given a set of integers, find a contiguous subset whose sum is zero. There can be duplicate
numbers in the input.
Input: Integer array e.g. 5,1,2,-3,7,-4
output: A subset that sums to zero.
e.g. 1,2,-3 OR -3,7,-4
* If there are no such subsets, then print nothing
* If there are multiple such subsets, then print any one
* If a matching subset is a subset of a larger matching subset, then print either one
* If there is a number '0' in the array, then it counts as a valid answer subarray.
What would be the complexity of the solution, if we were to print all subsets that sum to zero
(instead of just one)?
Solution: http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/ (This is a
variation of the Maximum Subarray problem)
 */
public class SumZero {



    //Bruit force solution O(n^2)
    private static boolean isSumZero(int [] arr){

        int n = arr.length;
        for(int i=0; i<n; i++){
            int sum = arr[0];

            for(int j=0; j<n; i++){
                if(j!=i) sum+=arr[j];

                if( arr[j] ==0 || sum ==0) return true;
            }
        }

        return false;
    }


    //O (log n) sol
    private static boolean isSumZeroHashing(int [] arr){

        Set<Integer> map = new HashSet<>();
        int n = arr.length;
        int sum =0;
        for(int i=0; i< n; i++){
            sum+=arr[i];
            if( arr[i] ==0 || sum ==0 || map.contains(sum)) return true;
            map.add(sum);
        }
        return  false;
    }


    public static void main (String [] args){
        int [] arr ={5,1,2,-3,7,-4};

        boolean flag = isSumZero(arr);
        System.out.println(flag);
        flag = isSumZeroHashing(arr);
        System.out.println(flag);

    }

}
