package com.recursion.two;

public class Prob4GroupSum5 {
    public boolean groupSum5(int start, int[] nums, int target) {

        boolean flag = sumNumbers2(start, nums, target);
        return flag;
    }


    boolean sumNumbers2 (int start, int[] nums, int target) {
        if( start >= nums.length)
            if (target == 0 )
                return true;
            else
                return false;

        if (sumNumbers2(start + 1, nums, target - nums[start])) {
            if( start+1 <nums.length && nums[start]%5 == 0 && nums[start+1] ==1){
                return false;
            }
            if(start+1 <nums.length && nums[start]%5 != 0 && nums[start+1] !=1 ){
                return false;
            }
            return true;
        }


       /* if(nums[start]%5 == 0 ){
             return false;
        }*/


        if (sumNumbers2(start + 1, nums, target)) {
            return true;
        }

        return false;
    }
}
