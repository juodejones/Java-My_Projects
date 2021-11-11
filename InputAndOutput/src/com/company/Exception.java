package com.company;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exception {

    public static void main(String[] args) {
        try {
            divideMain();
        } catch (NoSuchElementException | ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Unable to process the output, exiting...");
        }
    }

    public static void divideMain() {
        int x;
        int y;
        try {
            x = getIntEAFP();
            y = getIntEAFP();
            System.out.println("x is " + x + ", y is " + y);
        }catch (NoSuchElementException e) {
            throw new NoSuchElementException("Invalid Input");
        }catch (ArithmeticException e) {
            throw new ArithmeticException("Please enter an integer");
        }
        System.out.println("x / y is " + divideEAFP(x,y));
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer :");
        boolean isValid = true;
        String input = scanner.next();
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    public static int getIntEAFP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer :");
        while (true) {
            try {
                return sc.nextInt();
            } catch (NoSuchElementException e) {
                //looping again to get the correct input
                sc.nextLine();
                System.out.println("Please enter an integer");
            }
        }

    }

    public static int divideLBYL(int x, int y) {
        if ( y != 0) {
            return x / y;
        }
        return 0;
    }

    public static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
    }
}
