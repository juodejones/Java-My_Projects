package com.company.series;

public class Series {

    public static int nSum(int n ) {
        int sum =0, i=0;
        do {
            sum += i;
            System.out.print(sum + "\t");
            i++;
        } while (i <n );
        return sum;
    }

    public static int factorial(int n) {
        int fact = 1, i = 1;
        do {
            fact *= i;
            System.out.print(fact + "\t");
            i++;
        } while (i < n);
        return fact;
    }

    public static void fibonacci(int n) {
        int a=0,b =1,fibo =0;
        if (n == 0) {
            System.out.println(a);
        } else if (n == 1) {
            System.out.println(a + "\t" + b);
        } else if (n > 1){
            System.out.print(a + "\t" + b + "\t");
            for (int i = 0; i < n-1; i++) {
                fibo = a + b;
                System.out.print(fibo + "\t");
                a = b;
                b = fibo;
            }
        }
    }
}
