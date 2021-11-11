package com.jones;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        lShapedPlots();
    }

    public static void goodness() {
        try ( Scanner scanner = new Scanner(System.in)) {
            int cases = scanner.nextInt();
            scanner.nextLine();
            int[] operations = new int[cases];


            for (int i = 0; i < cases; i++){

                String str;
                int N; //Length of the string
                int requiredScore;
                N = scanner.nextInt();
                requiredScore = scanner.nextInt();
                scanner.nextLine();
                str = scanner.nextLine().toUpperCase();
                int goodNessScore = 0;
                int operation = 0;


                for (int j = 0; j < str.length() / 2; j++) {
                    if (str.charAt(j) != str.charAt(N - (j + 1))) {
                        goodNessScore++;
                    }
                }

                if (goodNessScore == requiredScore) {
                    //Do nothing
                } /*else if (goodNessScore < requiredScore) {
                    for (int j = 0; j < str.length() / 2; j++) {
                        if (str.charAt(j) == str.charAt(N - (j + 1))) {
                            char character = str.charAt(j);
                            str.replace(str.charAt(j), (char) ((int) character + 1));
                            operation++;
                            operations[i] = operation;
                        }
                    }
                }*/ else {
/*
                    for (int j = 0; j < str.length() / 2; j++) {
                        if (str.charAt(j) != str.charAt(N - (j + 1))) {
                            str.replace(str.charAt(j), str.charAt(N - (j + 1)));
                            operation++;
                            operations[i] = operation;
                        }
                    }
*/
                    operations[i] = Math.max(goodNessScore, requiredScore) - Math.min(goodNessScore, requiredScore);

                }
            }

            for (int i = 0; i < cases; i++) {
                System.out.println("Case #" + (i + 1) + ": " + operations[i]);
            }
        }
    }

    public static void lShapedPlots() {

        int num = 0, temp;

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp = matrix[i][j];
                if ( num == temp) {

                }
                num = matrix[i][j];
            }
        }

    }

}
