package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob13ChangePiTest {
    Prob13ChangePi change = new Prob13ChangePi();

    @Test
    public void changePi() {
        assertEquals("3.143.14",change.changePi("pipi"));
    }
}