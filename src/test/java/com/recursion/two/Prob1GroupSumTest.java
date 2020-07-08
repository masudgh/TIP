package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob1GroupSumTest {
    Prob1GroupSum sum = new Prob1GroupSum();

    @Test
    public void groupSum() {
        int [] list1 = {2,4,8};
        assertTrue(sum.groupSum(0, list1,10));
        assertTrue(sum.groupSum(0, list1,14));
        assertFalse(sum.groupSum(0, list1,9));
    }
}