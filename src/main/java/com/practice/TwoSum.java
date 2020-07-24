package com.practice;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    private static int [] sortedArr = { 4, 5, 7, 8, 18};
    private static int [] sortedArr2 = { 4};
    private static int [] unsortedArr = {  7, 8, 10, 20, 6};

    static boolean isUnsortedSum(int [] arr,  int target){
        if(arr == null) return false;
        int n = arr.length;
        if (n==1 ) return arr[0]==target;

        Set<Integer> set = new HashSet<>();

        set.add(arr[0]);

        for(int i=1; i<n; i++){
            int comp = target - arr[i];
            if( set.contains( comp)) return true;
            set.add(arr[i]);
        }

        return false;
    }

    static boolean isSortedSum(int [] arr, int target){
        if(arr == null) return false;
        int n = arr.length;
        if (n==1 ) return arr[0]==target;

        int l = 0;
        int r = n-1;

        while (l<r){
            if(arr[l]+arr[r] == target) return true;
            else if((arr[l]+ arr[r])>target) r--;
            else l++;
        }

        return false;
    }

    public static void main (String [] args){

        System.out.println(isSortedSum(sortedArr2, 41));
        System.out.println(isUnsortedSum(unsortedArr, 1));
    }
}
