package com.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciDPTest {
    FibonacciDP fibonacci = new FibonacciDP();
    @Test
    public void printFibonacci() throws Exception {
        fibonacci.printFibonacci(7);
    }

}