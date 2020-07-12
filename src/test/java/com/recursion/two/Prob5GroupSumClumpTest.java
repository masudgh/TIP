package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob5GroupSumClumpTest {

    Prob5GroupSumClump groupSum = new Prob5GroupSumClump();

    @Test
    public void groupSumClump() {

        int [] arr ={8, 2, 2, 1};
        assertTrue(groupSum.groupSumClump(0, arr,9));
       // assertFalse();
    }
}