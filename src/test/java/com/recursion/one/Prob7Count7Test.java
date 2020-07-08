package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob7Count7Test {
    Prob7Count7 countSeven = new Prob7Count7();

    @Test
    public void count7() {
        assertEquals(2, countSeven.count7(717));
    }
}