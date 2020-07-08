package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob30StrDistTest {
    Prob30StrDist dist = new Prob30StrDist();

    @Test
    public void strDist() {

        assertEquals(3,dist.strDist("catcowcat","cow"));
    }
}