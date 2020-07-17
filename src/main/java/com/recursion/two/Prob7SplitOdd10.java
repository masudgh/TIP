package com.recursion.two;

/*
Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one
group is a multiple of 10, and the sum of the other group is odd. Every int must be in one group
or the other. Write a recursive helper method that takes whatever arguments you like, and make
the initial call to your recursive helper from splitOdd10(). (No loops needed.)


splitOdd10([5, 5, 5]) → true
splitOdd10([5, 5, 6]) → false
splitOdd10([5, 5, 6, 1]) → true
 */
public class Prob7SplitOdd10 {

    public boolean splitOdd10(int[] nums) {
        if (nums.length ==0) return false;
        if (nums.length ==1 ){
            return (nums[0]%2==1);
        }
        int n = nums.length;
        int target =0;

        for(int j=1; j<n; j++){
            target +=nums[j];
        }
        return splitOdd10(nums, 0, nums[0], target);
    }

    public boolean splitOdd10(int[] nums, int start,  int sum, int target) {

        int n = nums.length;

        if ( (sum % 10 == 0 && target % 2 > 0) || (target % 10 == 0 && sum % 2 > 0) ) return true;

        if(sum - nums[start]>=0 && start+1 <n )
            if( splitOdd10( nums,start+1, sum - nums[start],  target+ nums[start])) return true;

        if(target - nums[start]>=0 && start+1 <n )
            if( splitOdd10( nums, start+1,  sum+nums[start],  target - nums[start] ) ) return true;

        return false;
    }


    public boolean bruitForceSol(int[] nums){

        int n = nums.length;
        int sum=0;
        int target;
        for(int i=0; i<n; i++){

            sum += nums[i];
            target=0;
            for(int j=i+1; j<n; j++){
                target +=nums[j];
            }

            if( sum % 10 == 0 && target % 2 >0 ){
                return true;
            }
        }


        return false;
    }




}
