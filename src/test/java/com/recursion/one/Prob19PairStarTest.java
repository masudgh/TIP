package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob19PairStarTest {
    Prob19PairStar star = new Prob19PairStar();

    @Test
    public void pairStar() {
        assertEquals("hel*lo",star.pairStar("hello"));
    }
}