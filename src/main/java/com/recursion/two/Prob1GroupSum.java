package com.recursion.two;

public class Prob1GroupSum {
    public boolean groupSum(int start, int[] nums, int target) {
        if( start >= nums.length)
            if (target == 0 ) return true;
            else return false;
        if( groupSum( start+1, nums, target-nums[start])) return true;

        if( groupSum( start+1, nums, target ) ) return true;

        return false;
    }

}
