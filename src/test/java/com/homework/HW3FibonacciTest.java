package com.homework;

import com.homework.Recursive.HW3Fibonacci;
import org.junit.Test;

public class HW3FibonacciTest {

    HW3Fibonacci fibonacci = new HW3Fibonacci();
    @Test
    public void printFibonacci() {
        fibonacci.printFibonacci(2);
        fibonacci.printFibonacci(4);
        fibonacci.printFibonacci(21);
    }
}