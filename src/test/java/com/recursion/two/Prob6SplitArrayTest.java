package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob6SplitArrayTest {

    Prob6SplitArray sArray = new Prob6SplitArray();

    @Test
    public void splitArray() {
        int [] arr = {5, 2, 3};
        assertTrue(sArray.splitArray(arr));
    }
}