package com.dynamic;

import com.homework.Recursive.HW5GroupSum;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GroupSumDPTest {
    HW5GroupSum sum = new HW5GroupSum();

    @Test
    public void groupSum() {
        int  [] arr = { 2,4,7,9,8};
        assertTrue(sum.groupSum(arr,0,11));
        assertTrue(sum.groupSum(arr,0,9));
        assertTrue(sum.groupSum(arr,0,30));
        assertFalse(sum.groupSum(arr,0,1));

    }
}