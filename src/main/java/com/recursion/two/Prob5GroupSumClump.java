package com.recursion.two;

/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group s
ums to the given target, with this additional constraint: if there are numbers in the array that a
re adjacent and the identical value, they must either all be chosen, or none of them chosen.
For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen
or not, all as a group. (one loop can be used to find the extent of the identical values).


groupSumClump(0, [2, 4, 8], 10) → true
groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
groupSumClump(0, [2, 4, 4, 8], 14) → false
 */
public class Prob5GroupSumClump {

    public boolean groupSumClump(int start, int[] nums, int target) {
      /*
        if(start >= nums.length)
            return target == 0;

        while(start+1 < nums.length && nums[start]== nums[start+1]){
            target-= nums[start];
            start++;
        }

        if(groupSumClump(start+1, nums, target- nums[start] )) return true;

        return groupSumClump(start + 1, nums, target);

*/

        if(start >= nums.length)
            return target == 0;

        //Identical check
        boolean idential = false;
        int iTarget = target;
        int iStart = start;
        while(iStart+1 < nums.length && nums[iStart]== nums[iStart+1]){
            iTarget -= nums[iStart];
            iStart++;
            idential = true;
            // if (iTarget<0 ) return false;
        }
        if(idential){
            iTarget -= nums[iStart];
        }

         if (idential && iTarget == 0 ) return true;


         if(idential && iTarget != 0)
             //return false;
             return groupSumClump(iStart+1, nums, target);

        if(groupSumClump(start+1, nums, target- nums[start]) ) return true;

        if(groupSumClump(start + 1, nums, target) ) return true;

        return false;

    }
}
