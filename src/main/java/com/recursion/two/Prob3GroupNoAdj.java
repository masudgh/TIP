package com.recursion.two;

public class Prob3GroupNoAdj {
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if( start >= nums.length)
            if (target == 0 ) return true;
            else return false;

        if( groupNoAdj( start+2, nums, target-nums[start])) return true;

        if( groupNoAdj( start+1, nums, target ) ) return true;

        return false;
    }

}
