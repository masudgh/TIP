package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob28StrCountTest {

    Prob28StrCount count = new Prob28StrCount();

    @Test
    public void strCount() {
        assertEquals(2,
                count.strCount("catcowcat", "cat"));
    }
}