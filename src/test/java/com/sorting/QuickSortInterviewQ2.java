package com.sorting;

import java.util.Arrays;

public class QuickSortInterviewQ2 {


    /*
    selection algorithm to find the k-th
    smallest element in an unordered list. It is related to the quick sort sorting algorithm.
    Input: arr[] = {7, 10, 4, 3, 20, 15}
           k = 3
    Output: 7

    Input: arr[] = {7, 10, 4, 3, 20, 15}
           k = 4
    Output: 10
     */



    private static int findKThValue(int [] arr, int k){

        return doQuickSort(  arr, 0, arr.length-1, k);

    }


    private static int doQuickSort( int [] arr, int left, int right, int k){

        if(arr==null) return -1;
        int val = 0;
        int pi =0;
        if(right> left) {
            pi = getPartition(arr, left, right);
            System.out.println(pi);
            val = doQuickSort(arr, left, pi - 1, k);
            val = doQuickSort(arr, pi + 1, right, k);
        }

        if(k == pi) {
            return arr[k-1];
        }

        return  arr[k-1];

    }

    private static int getPartition (int [] arr, int low, int high)
    {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;    // increment index of smaller element
                swap (arr, i, j);
            }
            System.out.println(Arrays.toString(arr));
        }

        swap (arr, i + 1, high);
        return (i + 1);
    }

    public static void swap(int [] arr, int i, int j){

        int tmp = arr[i];
        arr[i] =arr[j];
        arr[j] = tmp;
    }



    public static void main(String [] args){
        int [] arr = {12, 3, 5, 7, 4, 19, 26};
        System.out.println( " Kthe position : "+   findKThValue(arr, 3));

    }


}
