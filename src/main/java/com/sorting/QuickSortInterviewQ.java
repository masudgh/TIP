package com.sorting;

/*
 "how do you delete the duplicates from the array."

 */
public class QuickSortInterviewQ {

    QuickSort qs = new QuickSort();

    int [] deleteDuplicate(int [] arr){

        qs.doQuickSort(arr);

        int n = arr.length;
        int[] tmp = new int[n];

        int i=0;
        for(int j=0; j < arr.length; j++){
            while(j <= arr.length-2 && arr[j]== arr[j+1]){
                j++;
            }
            tmp[i++]=arr[j];
        }

        return tmp;



    }

}
