package com.recursion.two;

/*

Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start
index, such that the group sums to the given target? However, with the additional constraint that all
 6's must be chosen. (No loops needed.)

groupSum6(0, [5, 6, 2], 8) → true
groupSum6(0, [5, 6, 2], 9) → false
groupSum6(0, [5, 6, 2], 7) → false
 */
public class Prob2GroupSum6 {

    public boolean groupSum6(int start, int[] nums, int target) {
        return sumNumbers(start, nums, target);
    }

    boolean sumNumbers (int start, int[] nums, int target) {
        if( start >= nums.length)
            if (target == 0 )
                return true;
            else
                return false;
        if (sumNumbers(start + 1, nums, target - nums[start])) {
            return true;
        }
        if(nums[start] == 6){
            return false;
        }
        if (sumNumbers(start + 1, nums, target)) {
            return true;
        }

        return false;
    }

}
