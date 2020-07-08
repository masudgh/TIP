package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob26ParenBitTest {

    Prob26ParenBit bit = new Prob26ParenBit();

    @Test
    public void parenBit() {
        assertEquals("(abc)",bit.parenBit("xyz(abc)123"));
    }
}