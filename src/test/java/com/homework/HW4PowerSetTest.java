package com.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HW4PowerSetTest {
    HW4PowerSet powerset = new HW4PowerSet();

    @Test
    public void printSubset() {
        int [] arr = {1,2,3};
        powerset.printSubset(arr);
    }
}