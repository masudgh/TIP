package com.sorting;

public class BubbleSort {


    /**
     *  BUBBLE SORT -Stable sort
     *  best O(n) 	avg O(n^2) 	worst O(n^2)
     * @param arr
     */

    void doBubbleSort( int [] arr){
        int len = arr.length;
        for(int i=0; i< len; i++){

            for(int j=i+1; j< len;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }

            }
        }
    }


}
