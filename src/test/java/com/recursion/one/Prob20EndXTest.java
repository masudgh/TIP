package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob20EndXTest {

    Prob20EndX x = new Prob20EndX();

    @Test
    public void endX() {
        assertEquals( "hixxxx", x.endX("xxhixx"));
    }
}