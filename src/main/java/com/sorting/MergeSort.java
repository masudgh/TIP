package com.sorting;

public class MergeSort {

    /**
     * MERGE SORT -Stable sort
     * best=O(n log(n)) 	average=O(n log(n)) 	worst=O(n log(n))
     * @param arr
     */


    public void doMergeSort(int [] arr, int left, int right){

        if (left < right) {
            int middle = (left + right) / 2;

            doMergeSort(arr, left, middle);
            doMergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    void merge(int [] arr, int l,  int m,  int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }


    /*

    Sort two arrays individually and merge them. To sort each array, call merge sort
    splitting the array in half (if it is not possible, the array is already sorted).

     */


}
