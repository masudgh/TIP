package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob2GroupSum6Test {

    Prob2GroupSum6 sum6 = new Prob2GroupSum6();
    @Test
    public void groupSum6() {
        int [] list1 = {5,6,2};
        assertTrue(sum6.groupSum6(0, list1,8) );
        assertFalse(sum6.groupSum6(0, list1,9) );
        assertFalse(sum6.groupSum6(0, list1,7) );
    }
}