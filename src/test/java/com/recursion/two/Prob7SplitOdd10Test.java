package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob7SplitOdd10Test {
    Prob7SplitOdd10 splitOdd = new Prob7SplitOdd10();
    @Test
    public void splitOdd10() {
        int [][] testData = {{5, 5, 5},               // 0
                             {5, 5, 6},               // 1
                             {5, 5, 6, 1},            // 2
                             {6, 5, 5, 1},            // 3
                             {6, 5, 5, 1, 10},        // 4
                             {6, 5, 5, 5, 1},         // 5
                {1},                                  // 6
                {},                                   // 7
                {10, 7, 5, 5},                        // 8
                {10, 0, 5, 5},                        // 9
                {10, 7, 5, 5, 2},                     // 10
                {10, 7, 5, 5, 1}};                    // 11
/*

        assertTrue(splitOdd.splitOdd10( testData[0]));
        assertFalse(splitOdd.splitOdd10( testData[1]));
        assertTrue(splitOdd.splitOdd10( testData[2]));
        assertTrue(splitOdd.splitOdd10( testData[3]));
        assertTrue(splitOdd.splitOdd10( testData[4]));
        assertFalse(splitOdd.splitOdd10( testData[5]));
        assertTrue(splitOdd.splitOdd10( testData[6]));
        assertFalse(splitOdd.splitOdd10( testData[7]));
        assertTrue(splitOdd.splitOdd10( testData[8]));
        assertFalse(splitOdd.splitOdd10( testData[9]));
        assertTrue(splitOdd.splitOdd10( testData[10]));
        assertFalse(splitOdd.splitOdd10( testData[11]));
*/

        for(int i=0; i<12; i++){
            boolean flag = splitOdd.splitOdd10( testData[i]);
            System.out.println( flag);
        }
    }
}