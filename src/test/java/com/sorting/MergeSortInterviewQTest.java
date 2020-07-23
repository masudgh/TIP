package com.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortInterviewQTest {

    MergeSortInterviewQ msq = new MergeSortInterviewQ();

    @Test
    public void mergeSortedrrays() throws Exception {

        int [] arr1 = { 22, 66, 78, 81, 86};
        int [] arr2 = { 2, 24, 33, 34, 90};

        int[] arr = msq.mergeSortedrrays(arr2, arr1);


        for(int i: arr) System.out.print(i + " ");
        System.out.println();

    }

}