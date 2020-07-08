package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob21CountPairsTest {
    Prob21CountPairs pairs = new Prob21CountPairs();

    @Test
    public void countPairs() {
        assertEquals(1,pairs.countPairs("axa"));
    }
}