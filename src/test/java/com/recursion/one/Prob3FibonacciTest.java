package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob3FibonacciTest {
    Prob3Fibonacci fab = new Prob3Fibonacci();

    @Test
    public void fibonacci() {
        assertEquals( 1, fab.fibonacci(2));
    }
}