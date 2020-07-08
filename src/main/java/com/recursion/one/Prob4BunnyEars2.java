package com.recursion.one;

public class Prob4BunnyEars2 {
    public int bunnyEars2(int bunnies) {
        int ears;
        if (bunnies ==0 ) return 0;
        if (bunnies%2 == 1 ){
            ears = 2;
        }else{
            ears =3;
        }
        return bunnyEars2 (bunnies-1)+ears;

    }

}
