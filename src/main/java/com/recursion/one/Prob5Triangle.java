package com.recursion.one;

public class Prob5Triangle {

    public int triangle(int rows) {
        if(rows <=0) return 0;

        int nBlocks =  triangle(rows-1) + rows;
        return nBlocks;

    }


}
