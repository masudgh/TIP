package com.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HW3FibonacciTest {

    HW3Fibonacci fibonacci = new HW3Fibonacci();
    @Test
    public void printFibonacci() {
        fibonacci.printFibonacci(2);
        fibonacci.printFibonacci(9);
        fibonacci.printFibonacci(21);
    }
}