package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob5GroupSumClumpTest {

    Prob5GroupSumClump groupSum = new Prob5GroupSumClump();

    @Test
    public void groupSumClump() {

        int [] arr ={2, 4, 4, 8};
        boolean flag = groupSum.groupSumClump(0, arr,14);
        System.out.println(flag);

       // assertFalse();
    }
}