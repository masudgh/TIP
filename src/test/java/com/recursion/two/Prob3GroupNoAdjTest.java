package com.recursion.two;

import com.recursion.one.Prob30StrDist;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob3GroupNoAdjTest {

    Prob3GroupNoAdj dist = new Prob3GroupNoAdj();

    @Test
    public void groupNoAdj() {
        int [] list1 = {2, 5, 10, 4};
        assertFalse(dist.groupNoAdj(0, list1, 14));
        assertFalse(dist.groupNoAdj(0, list1, 7));
        assertTrue(dist.groupNoAdj(0, list1, 12));
    }
}