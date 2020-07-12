package com.recursion.two;

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
        if(idential && iTarget == 0) return true;
        //if (iTarget<0 ) return false;
        if(idential && iTarget != 0) return false;
        //   return groupSumClump(iStart, nums, iTarget);

        if(groupSumClump(start+1, nums, target- nums[start] )) return true;

        return groupSumClump(start + 1, nums, target);

    }
}
