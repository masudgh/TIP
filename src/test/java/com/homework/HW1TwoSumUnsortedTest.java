package com.homework;

import com.homework.Warmup.HW1TwoSumUnsorted;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HW1TwoSumUnsortedTest {

    HW1TwoSumUnsorted twoSum = new HW1TwoSumUnsorted();
    int [] unsortedArray1 ;
    int [] unsortedArray2 ;
    int [] unsortedArray3 ;

    int [] sortedArray1;
    int [] sortedArray2;
    int [] sortedArray3;

    @Before
    public  void init(){
        unsortedArray1 = new int [] { 100,5,10,9,15,45,3,-5, -3 ,33};
        unsortedArray2 = new int [] { 4};
        unsortedArray3 = new int [] { };

        sortedArray1 = new int [] { -19, -15, 0, 1 ,2 , 3 ,5 ,6, 7, 100};
        sortedArray2 = new int [] { -19};
        sortedArray3 = new int [] { };

    }



    @Test
    public void isTwoSumBrutForce() {
        assertTrue(twoSum.isTwoSumBrutForce(unsortedArray1, 30)); //Positive test
        assertTrue(twoSum.isTwoSumBrutForce(sortedArray1, -14)); //Positive Test

    }

    @Test
    public void isTwoSumUnsorted() {
        assertTrue(twoSum.isTwoSumUnsorted(unsortedArray1, -8)); //Positive test
        assertTrue(twoSum.isTwoSumUnsorted(unsortedArray1, 30)); //Positive test
        assertFalse(twoSum.isTwoSumUnsorted(unsortedArray1, 1000)); //Negative test
        assertFalse(twoSum.isTwoSumUnsorted(unsortedArray2, 12)); //Edge case
        assertFalse(twoSum.isTwoSumUnsorted(unsortedArray3, 12)); //Edge case
        assertFalse(twoSum.isTwoSumUnsorted(null, 12)); //Edge case
    }

}