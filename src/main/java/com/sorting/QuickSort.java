package com.sorting;

/**
 *   QUICK SORT
 *   best= O(n log(n)) 	average=O(n log(n)) 	worst=O(n^2)
 *
 *
*/
public class QuickSort {

    public void doQuickSort( int [] arr){
        doQuickSort(arr, 0, arr.length-1);
    }

    private void doQuickSort( int [] arr, int left, int right){

        if(arr==null) return;

        if(right> left) {
            int pi = getPartition(arr, left, right);
            doQuickSort(arr, left, pi - 1);
            doQuickSort(arr, pi + 1, right);
        }

    }

    int getPartition (int [] arr, int low, int high)
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
        }
        swap (arr, i + 1, high);
        return (i + 1);
    }

    void swap(int [] arr, int i, int j){

        int tmp = arr[i];
        arr[i] =arr[j];
        arr[j] = tmp;
    }
}
