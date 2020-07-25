package com.practice;

public class GroupSum {

    private static int [] arr = {  7, 8, 10, 20, 6};
    private static int [] arrNull = {};
    private static int [] arrOne = {21};

    private static boolean isGroupSum( int [] arr, int i, int target){
        if(arr == null) return false;
        int n = arr.length;
        if (n==1 ) return arr[0]==target;

        if(i==n) return target ==0;

        if (isGroupSum(arr, i+1, target-arr[i]) ) return true;  //Select this number
        else if (isGroupSum(arr, i+1, target) ) return true;   //Not select this number

        return false;
    }

    public static void main (String [] args){

        System.out.println(isGroupSum(arr,0, 25));
        System.out.println(isGroupSum(arrNull,0, 25));
        System.out.println(isGroupSum(arrOne,0, 25));
    }
}
