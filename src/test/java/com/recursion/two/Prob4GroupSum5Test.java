package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob4GroupSum5Test {

    Prob4GroupSum5 sum5 = new Prob4GroupSum5();

    @Test
    public void groupSum5() {
        int [] list1 = {2, 5, 10, 4};
        int [] list2 = {3,5,1};

        boolean flag = sum5.groupSum5(0,list2,4);

        System.out.println(flag);
        /*
        assertTrue(sum5.groupSum5(0,list1,19));
        assertTrue(sum5.groupSum5(0,list1,17));
        assertFalse(sum5.groupSum5(0,list1,12)); */
    }
}