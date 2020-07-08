package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob10CountXTest {
    Prob10CountX count = new Prob10CountX();

    @Test
    public void countX() {
        assertEquals( 3, count.countX("xhixhix"));
    }
}