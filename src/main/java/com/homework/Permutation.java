package com.homework;

import java.util.Arrays;

public class Permutation {

    public void getPermutation(char[] arr){
        getPermutation( arr,0);
    }

    public void getPermutation(char[] arr, int i){
        if( i == arr.length){
            System.out.println("'"+ Arrays.toString(arr) + "'");
            return;
        }

        for(int j=i; j< arr.length; j++) {
            swap(arr, i , j);
            getPermutation(arr, i+1);
            swap(arr, i , j);
            System.out.println(" -->backtrack"+ Arrays.toString(arr) + "'");

        }


    }

    void swap (char[] arr, int i, int j){
        char tmp =arr[i];
        arr[i] = arr [j];
        arr[j] = tmp;
    }
}
