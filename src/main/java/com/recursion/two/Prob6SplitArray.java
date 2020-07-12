package com.recursion.two;

public class Prob6SplitArray {
    public boolean splitArray(int[] nums) {
        if (nums.length ==0) return true;
        if (nums.length ==1) return false;

        if(nums.length==2 )
            if( nums[0] == nums[1]) return true;
            else return false;

        int sum = nums[0]+nums[1];


        return isSplitArray( 1, nums, sum);
    }

    private boolean isSplitArray( int i, int [] arr, int sum){

        if(i== arr.length-1)
            if(sum%2 == 0) return true;
            else return false;


        i++;
        sum+=arr[i];
        return isSplitArray(i, arr, sum);

    }

}
