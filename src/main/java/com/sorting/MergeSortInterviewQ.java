package com.sorting;

public class MergeSortInterviewQ {

    /*
    Given two sorted arrays, add the elements of the second array into the first
     */

    int[] mergeSortedrrays( int [] left, int [] right){

        if( left.length == 0 & right.length ==0) return null;

        int l = left.length;
        int r = right.length;



        int [] arr = new int [l+r];

        int i=0;
        int j=0;
        int k=0;

        while(i< l && j < r){
            if(right[j]>left[i]){
                arr[k++] =left[i++];
            }else if(right[j]< left[i]){
                arr[k++] = right[j++];
            }

        }

        while(i< l){

            arr[k++]= left[i++];
        }

        while(j<r){
            arr[k++] = right[j++];
        }

        return arr;
    }
}
