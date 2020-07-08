package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob24StringCleanTest {
    Prob24StringClean strClean = new Prob24StringClean();

    @Test
    public void stringClean() {

        assertEquals("abcd",strClean.stringClean("abbbcdd"));
    }
}