package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob14NoXTest {
    Prob14NoX no = new Prob14NoX();

    @Test
    public void noX() {
        assertEquals("ab",no.noX("xaxb"));
    }
}