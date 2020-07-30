package com.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest extends SortingBaseTest {
    QuickSort qs = new QuickSort();
    @Test
    public void doQuickSort() throws Exception {
        printArr("Print before sorting", true);


        long t1 = System.currentTimeMillis();
        qs.doQuickSort(arrSmall);
        long t2 = System.currentTimeMillis() ;

        printArr("Print after QUICK sorting", true);
        System.out.println("Time [ms] : " + (t2-t1));


    }


    @Test
    public void doQuickSort2() throws Exception {


        int [] arr = {2,1,3,0,3};

        printArr("Print before sorting", arr);
        qs.doQuickSort(arr);

        printArr("Print after QUICK sorting", arr);


    }

}