package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob1FactorialTest {
    Prob1Factorial sol = new Prob1Factorial();

    @Test
    public void factorial() {
        assertEquals(24, sol.factorial(4));
    }
}