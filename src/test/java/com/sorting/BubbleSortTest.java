package com.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest extends SortingBaseTest {

    BubbleSort bs = new BubbleSort();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void doBubbleSort() throws Exception {

        printArr("Print before sorting", true);
        long t1 = System.currentTimeMillis();
        bs.doBubbleSort(arrSmall);
        long t2 = System.currentTimeMillis() ;
        printArr("Print after BUBBLE sorting", true);
        System.out.println("Time [ms] : " + (t2-t1));

    }

}