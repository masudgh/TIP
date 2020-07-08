package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob18AllStarTest {
    Prob18AllStar all = new Prob18AllStar();

    @Test
    public void allStar() {
       assertEquals( "h*e*l*l*o", all.allStar("hello"));
    }
}