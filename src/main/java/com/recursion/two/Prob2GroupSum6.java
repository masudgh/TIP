package com.recursion.two;

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
