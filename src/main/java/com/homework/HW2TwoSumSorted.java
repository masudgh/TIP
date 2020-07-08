package com.homework;

public class HW2TwoSumSorted {

        /*
         This method is O(n^2) Time complex Brute Force method. It will work for sorted
         or unsorted Array.
         */

        public boolean isTwoSumBrutForce(int[] nums, int target) {
            if ( nums == null) return false;
            int n = nums.length;
            if(n<=1) return false;

            for(int i =0;i<n; i ++){
                for(int j=i+1; j<n;j++){
                    if ( (nums[i]+ nums[j]) == target){

                        return true;
                    }
                }
            }
            return false;
        }


        /*
        Sorted array. Time Complexity is O(n) and Space complexity O(1). This return the if the  sum is possible by adding
        two numbers from the list and make it equals to target value.
        */

        public boolean isTwoSumSorted(int[] nums, int target) {

            if ( nums == null) return false;
            int n = nums.length;
            if(n<=1) return false;

            int left = 0;
            int right = n-1;

            while(left<right) {
                if(nums[left]+nums[right] == target) return true;
                else if (nums[left]+nums[right] > target) right--;
                else left++;
            }
            return false;
        }




}
