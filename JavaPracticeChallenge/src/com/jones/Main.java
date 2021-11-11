package com.jones;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        failedPassed();
    }
    public static void bitMulti() {
        System.out.println("Enter the number : ");
        int number = scanner.nextInt();
        int result = number << 2;
            System.out.println("Answer is :" + result);
    }

    public static void toCheckQuadratic(){
        int a,b,c,result = 0; double x1, x2;
        System.out.println("For a quadratic equation ax^2 + bx +c = 0" + "\n(a, b, c) is,");
        a = scanner.nextInt();
        scanner.nextLine();
        b= scanner.nextInt();
        scanner.nextLine();
        c = scanner.nextInt();
        scanner.nextLine();

        x1 = (-b + Math.sqrt((b*b) -(4*a*c))) / (2*a);
        x2 = (-b - Math.sqrt((b*b) -(4*a*c))) / (2*a);

        if( x1 >=0 ) {
            result ++;
            if (x2 >= 0) {
                result ++;
            }
        }
        System.out.println("The quadratic equation has "+result + " real roots");
    }


    public static void arrayOfMultiples() {
        System.out.println("Enter the number: ");
        int num = scanner.nextInt();
        System.out.println("Enter the length: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for ( int  i = 1 ; i <=length; i++){
            array[i-1] = num * i;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void squarePatch(){
        System.out.println("Enter the element to be patch: ");
        int n = scanner.nextInt();
        int [][] array = new int[n][n];

        for (int i = 0 ; i < array.length; i++){
           for (int j = 0 ; j < array.length; j++){
               array[i][j] = n;
           }
        }

        System.out.println("[");
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("]");

    }

    public static int arraySum(int[]  array){
        /*int sum = 0, i = 0;
        System.out.println("Sum is " + sum);*/

        if( array.length == 0 ){
            return 0;
        }
        return array[0]+arraySum(Arrays.copyOfRange(array,1,array.length));

    }

    public static void failedPassed() {
        System.out.println("Enter your percentage: ");
        String m1 = scanner.nextLine();
        System.out.println("Enter the pass percentage: ");
        String m2 = scanner.nextLine();
        int userMark = Integer.parseInt(m1.substring(0,2));
        int passMark = Integer.parseInt(m2.substring(0,2));
        if (userMark >= passMark)
            System.out.println("You passed the test.");
        else
            System.out.println("You failed the exam.");
    }





}
