package com.homework;

import java.util.HashSet;
import java.util.Set;

/*

Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
Create a Recursion Tree to support you solution.
groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false

*/

public class HW1TwoSumUnsorted {
    /*
     This method is O(n^2) Time complex Brute Force method. It will work for sorted
     or unsorted Array.
    */
    public boolean isTwoSumBrutForce(int[] nums, int target) {
        if ( nums == null) return false;
        int n = nums.length;
        if(n<=1) return false;

        for(int i =0;i<n; i ++){
            for(int j=i+1; j<n;j++){
                if ( (nums[i]+ nums[j]) == target){

                    return true;
                }
            }
        }
        return false;
    }


    /*
    Unsorted array. Time Complexity is O(n) and Space complexity O(n). This return the if
    the  sum is possible by adding two numbers from the list and making it equals to target
    value.
    */
    public boolean isTwoSumUnsorted(int[] nums, int target) {

        if ( nums == null) return false;
        int n = nums.length;
        if(n<=1) return false;

        Set<Integer> set = new HashSet<>();
        set.add( nums[0]);
        for(int i =1; i<n; i ++){
            int comp = target - nums[i];
            if (set.contains(comp)){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }



}
