package com.recursion.one;

public class Prob2BunnyEars {
    public int bunnyEars(int bunnies) {
        if (bunnies <= 0 ) return 0;
        return bunnyEars (bunnies-1) + 2 ;
    }
}
