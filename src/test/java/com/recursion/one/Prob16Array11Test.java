package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob16Array11Test {
    Prob16Array11 arr = new Prob16Array11();

    @Test
    public void array11() {
        int [] list = {1, 2, 3, 4};
        assertEquals(0, arr.array11(list,0));
    }
}