package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob9PowerNTest {
    Prob9PowerN pow = new Prob9PowerN();

    @Test
    public void powerN() {
        assertEquals(27,pow.powerN(3,3));
    }
}