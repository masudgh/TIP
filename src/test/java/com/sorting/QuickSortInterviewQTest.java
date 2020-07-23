package com.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortInterviewQTest extends  SortingBaseTest{
    QuickSortInterviewQ qsq = new QuickSortInterviewQ();

    @Test
    public void deleteDuplicate() throws Exception {

        printArr("Print before sorting", true);


        long t1 = System.currentTimeMillis();
        int [] tmp =  qsq.deleteDuplicate(arrSmall);
        long t2 = System.currentTimeMillis() ;

        printArr("Print after Delete", tmp);
        System.out.println("Time [ms] : " + (t2-t1));

    }

}