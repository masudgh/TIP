package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob22CountAbcTest {
    Prob22CountAbc abc =new Prob22CountAbc();

    @Test
    public void countAbc() {
        assertEquals(2, abc.countAbc("abaxxaba"));

    }
}