package com.homework;

import com.homework.Warmup.HW2TwoSumSorted;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HW2TwoSumSortedTest {

    HW2TwoSumSorted twoSum = new HW2TwoSumSorted();
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
    public void isTwoSumSorted() {
        assertTrue(twoSum.isTwoSumSorted(sortedArray1, -14)); //Positive Test
        assertTrue(twoSum.isTwoSumSorted(sortedArray1, 11)); //Positive Test
        assertFalse(twoSum.isTwoSumSorted(sortedArray1, 1000)); //Negative Test
        assertFalse(twoSum.isTwoSumSorted(sortedArray2, 12)); //Edge case
        assertFalse(twoSum.isTwoSumSorted(sortedArray3, 12)); //Edge case
        assertFalse(twoSum.isTwoSumSorted(null, 12)); //Edge case
    }

}