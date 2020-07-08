package com.recursion.one;

public class Prob17Array220 {


        public boolean array220(int[] nums, int index) {

            if(index >= nums.length) return false;

            boolean flag = true;
            if(index+1==nums.length) flag =false;


            if(flag && nums[index]==0 && nums[index+1]==0) return true;
            if(flag && nums[index+1]/nums[index] == 10 & nums[index+1]%(10*nums[index])==0) return true;
            else {
                return array220(nums, index+1);
            }

        }


}
