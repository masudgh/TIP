package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob11CountHiTest {

    Prob11CountHi count = new Prob11CountHi();

    @Test
    public void countHiTest(){
        assertEquals(2, count.countHi("xhixhix"));
    }

}