package com.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest extends SortingBaseTest{

    MergeSort ms = new MergeSort();

    @Test
    public void doMergeSort() throws Exception {
        printArr("Print before sorting", false);

        int left =0;
        int right =arrLarge.length-1;

        long t1 = System.currentTimeMillis();
        ms.doMergeSort(arrLarge, left, right);
        long t2 = System.currentTimeMillis() ;

        printArr("Print after MERGE sorting", false);
        System.out.println("Time [ms] : " + (t2-t1));
    }

}