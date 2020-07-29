package com.homework;

import com.homework.Recursive.Permutation;
import org.junit.Test;

public class PermutationTest {
    Permutation perm = new Permutation();

    @Test
    public void getPermulation() {

        char [] arr = { 'A', 'B', 'C'};
        perm.getPermutation(arr);

    }
}