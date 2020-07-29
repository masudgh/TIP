package com.dynamic;

/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group
sums to the given target?
Create a Recursion Tree to support you solution.

groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false
 */
public class GroupSumDP {

    public boolean groupSum(int []  arr, int i, int target) {

        if (i == arr.length)
            return target ==0;


        return groupSum(arr, i + 1, target)
                || groupSum(arr, i + 1, target - arr[i]);

    }
}
