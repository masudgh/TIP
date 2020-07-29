package com.practice;

public class AMZ1 {

    /**
     * { "C", "A" },
     { "C", "B" },
     { "F", "C" },
     { "E", "D" },
     { "F", "E" },
     { "F", "F" }

     In this example C is manager of A,
     C is also manager of B, F is manager
     of C and so on.
     Input would be:
     6
     C,A
     C,B
     F,C
     E,D
     F,E
     F,F

     C=[A], E=[D], F=[C, E, F]}

     Output should be
     A - 0
     B - 0
     C - 2
     D - 0
     E - 1
     F - 5

     */

}
