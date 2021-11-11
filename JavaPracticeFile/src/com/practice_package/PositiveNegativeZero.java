package com.practice_package;

public class PositiveNegativeZero {

    public static void main (String[] args){
        chechknumber(-34);
        chechknumber(94);
        chechknumber(000);
    }

    public static void chechknumber(int number) {
        if (number > 0)
            System.out.println(number + " is Positive");
        else if (number < 0)
            System.out.println(number + " is Negative");
        else
            System.out.println(number + " is Zero");
    }
}
