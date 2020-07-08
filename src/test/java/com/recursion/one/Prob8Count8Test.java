package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob8Count8Test {
    Prob8Count8 countEight = new Prob8Count8();

    @Test
    public void count8() {
        assertEquals(4,countEight.count8(8818) );
    }
}