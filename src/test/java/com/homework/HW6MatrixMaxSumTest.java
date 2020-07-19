package com.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HW6MatrixMaxSumTest {
    HW6MatrixMaxSum maxSum = new HW6MatrixMaxSum();
    HW6MatrixMaxSum2 maxSum2 = new HW6MatrixMaxSum2();

    @Test
    public void maxSumInMatrix() {

        int[][] arr1 = {{9}};
        int[][] arr2 = {{1, 2, 3}};
        int[][] arr3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr4 = {{2, 2, 1, 1, 1}, {1, 2, 1, 1, 1}, {1, 2, 2, 1, 1}, {1, 1, 2, 2, 1}, {1, 1, 1, 2, 2}};

        assertEquals(maxSum.maxSumInMatrix(arr1),9);
        assertEquals(maxSum.maxSumInMatrix(arr2),6);
        assertEquals(maxSum.maxSumInMatrix(arr3),29);
        assertEquals(maxSum.maxSumInMatrix(arr4),18);

        assertEquals(maxSum2.maxSumInMatrix(arr1),9);
    }
}