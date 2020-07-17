package com.recursion.two;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob8Split53Test {
    Prob8Split53 split = new Prob8Split53();

    @Test
    public void split53() {
        int [] arr1 = {1, 1};
        int [] arr2 = { 1, 1, 1};
        int [] arr3 = { 2, 4, 2};
        boolean flag = split.split53( arr1);
        System.out.println( flag);
        flag = split.split53( arr2);
        System.out.println( flag);
        flag = split.split53( arr3);
        System.out.println( flag);

    }
}