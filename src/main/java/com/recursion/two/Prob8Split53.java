package com.recursion.two;

public class Prob8Split53 {

    public boolean split53(int[] nums) {
        if (nums.length ==0) return false;
        if (nums.length ==1 ) return false;
        return split53(nums, 0, 0, 0);
    }

    public boolean split53(int[] nums, int start,  int target3, int target5) {

        if(start >= nums.length)
            return ( target3 == target5 ) ;

        if(nums[start]%3==0 && nums[start]%5!=0) {
            target3 += nums[start];
            if  (split53( nums,start+1, target3 ,  target5)) return true;
        }
        if(nums[start]%5==0){
            target5 += nums[start];
            if  (split53( nums,start+1, target3 + nums[start],  target5)) return true;
        }

        if ( (split53( nums,start+1, target3 ,  target5 + nums[start])) ||
            (split53( nums,start+1, target3 + nums[start],  target5 )) ) return true;
        return false;
    }

}
