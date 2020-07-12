package com.homework;

public class HW5GroupSum {

    public boolean groupSum(int []  arr, int i, int target) {

        if (i == arr.length)
            return target ==0;


        return groupSum(arr, i + 1, target)
                || groupSum(arr, i + 1, target - arr[i]);

    }
}
