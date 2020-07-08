package com.recursion.one;

public class Prob16Array11 {
    public int array11(int[] nums, int index) {
        if(index >= nums.length) return 0;
        int count =0;
        if(nums[index] == 11) count++;

        return count+ array11(nums, index+1);

    }

}
