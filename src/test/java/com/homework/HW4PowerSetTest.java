package com.homework;

import com.homework.Recursive.HW4PowerSet;
import org.junit.Test;

public class HW4PowerSetTest {
    HW4PowerSet powerset = new HW4PowerSet();

    @Test
    public void printSubset() {
        int [] arr = {1,2,3};
        powerset.printSubset(arr);
    }
}