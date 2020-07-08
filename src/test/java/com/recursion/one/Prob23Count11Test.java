package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob23Count11Test {
    Prob23Count11 eleven = new Prob23Count11();

    @Test
    public void count11() {
        assertEquals(3,eleven.count11("abc11x11x11"));
    }
}