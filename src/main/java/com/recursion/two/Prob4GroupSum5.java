package com.recursion.two;
/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group
 sums to the given target with these additional constraints: all multiples of 5 in the array must
 be included in the group. If the value immediately following a multiple of 5 is 1, it must not be
 chosen. (No loops needed.)


groupSum5(0, [2, 5, 10, 4], 19) → true
groupSum5(0, [2, 5, 10, 4], 17) → true
groupSum5(0, [2, 5, 10, 4], 12) → false
 */
public class Prob4GroupSum5 {
 /*   public boolean groupSum5(int start, int[] nums, int target) {

        return sumNumbers2(start, nums, target);
    }


    boolean sumNumbers2 (int start, int[] nums, int target) {

        if( start >= nums.length)
            return  target == 0 ;

        if (sumNumbers2(start + 1, nums, target - nums[start])) {
            if (start + 1 < nums.length && nums[start] % 5 == 0)
                return !(nums[start + 1] == 1);
            else
                return true;
        }


        //Identical check
        boolean idential = false;
        int iTarget = target;
        int iStart = start;
        while(iStart+1 < nums.length && nums[iStart]% 5 == 0){
            iTarget -= nums[iStart];
            iStart++;
            idential = true;
        }


        if (idential && iTarget == 0 ) return true;


        if(idential && iTarget != 0)
            return sumNumbers2(iStart+1, nums, target);


       // return (sumNumbers2(start + 1, nums, target)) ;

        if(sumNumbers2(start+1, nums, target- nums[start]) ) return true;

        return (sumNumbers2(start + 1, nums, target) );



    }
}
*/


/*
public boolean groupSum5(int start, int[] nums, int target) {

        boolean flag = sumNumbers2(start, nums, target);
        return flag;
    }


    boolean groupSum5 (int start, int[] nums, int target) {
        if( start >= nums.length)
            if (target == 0 )
                return true;
            else
                return false;

        if (groupSum5(start + 1, nums, target - nums[start])) {
            if( start+1 <nums.length && nums[start]%5 == 0 && nums[start+1] ==1){
                return false;
            }
            if(start+1 <nums.length && nums[start]%5 != 0 && nums[start+1] !=1 ){
               return false;
            }
            return true;
        }



        if (groupSum5(start + 1, nums, target)) {
                return true;
                }

                return false;
                }
                }

 */

    public boolean groupSum5(int start, int[] nums, int target) {
        if (nums == null) return false;
        if (nums.length == 1 && nums[0] == target) ;
        return doGroupSum5(0 , nums,  target);
    }

    boolean doGroupSum5(int start, int[] nums, int target) {

        if (start >= nums.length)
            return (target == 0) ;

       if (start + 1 < nums.length && nums[start] % 5 == 0 && nums[start + 1] == 1){
           return doGroupSum5(start + 2, nums, target-nums[start]);
        } else if (start + 1 < nums.length && nums[start] % 5 == 0 && nums[start + 1] != 1) {
            return doGroupSum5(start + 1, nums, target-nums[start]) ;
        }else


       if( doGroupSum5( start+1, nums, target-nums[start])) return true;

        if( doGroupSum5( start+1, nums, target ) ) return true;

        return false;



        /*
         if( groupSum( start+1, nums, target-nums[start])) return true;

        if( groupSum( start+1, nums, target ) ) return true;

        return false;
         */
    }
}