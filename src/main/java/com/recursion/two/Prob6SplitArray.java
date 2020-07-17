package com.recursion.two;

/*
Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the
two groups are the same. Every int must be in one group or the other. Write a recursive helper method
that takes whatever arguments you like, and make the initial call to your recursive helper from
splitArray(). (No loops needed.)


splitArray([2, 2]) → true
splitArray([2, 3]) → false
splitArray([5, 2, 3]) → true
 */


public class Prob6SplitArray {
    public boolean splitArray(int[] nums) {
        if (nums.length ==0) return true;
        if (nums.length ==1) return false;

        if(nums.length==2 )
            return nums[0] == nums[1];


        int sum = nums[0]+nums[1];

        return isSplitArray( 1, nums, sum);
    }

    private boolean isSplitArray( int i, int [] arr, int sum){

        if(i== arr.length-1)
            return sum%2 == 0;

        i++;
        sum+=arr[i];
        return isSplitArray(i, arr, sum);

    }

}
