package com.For_Loop;

public class Main {

    public static void main(String[] args) {

//        for (int i=2; i<=8; i++){
//            System.out.println("Interest for $10,000 at " + i + "% interestrate is $" + String.format("%.2f",calculateInterest(10000, i)));
//        }

/*
        //Prime numbers from a range generated
        int count = 0;
        System.out.println("The Prime Numbers are: ");
        for (int n=34; n<=50; n++){
            if(isPrime(n)){
                System.out.println(n);
                count++;
            }
            if(count==3){
                System.out.println("Exiting for loop");
                break;
            }
        }*/
/*
        //Sum 3 and 5 challenge
        int sum = 0;
        int count = 0;
        for (int n=1; n<=1000; n++){
            if ((n % 3 == 0) && (n % 5 ==0)){
                System.out.println(n + " is divided by both three and five");
                sum += n;
                count++;
            }
            if (count==5){ break; }
        }
        System.out.println("Sum of these numbers is " + sum);
*/
//        System.out.println(isEvenNumber(36));

        //IS EVEN NUMBER.MAIN
        /*int number = 4;
        int finishNumber = 20;
        int count = 0;

        while (number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println("Even number " + number);
            count++;
            if (count==5){
                System.out.println("Exiting the loop");
                break;
            }
        }*/

        ///TEEN NUMBER CHECKER.MAIN
        /*int a = 43 ; int b = 12 ; int c = 53 ;
        if (hasTeen(a,b,c)){
            System.out.println("One of the number is a teen");
        }else {
            System.out.println("None of the number is a teen");
        }*/

        //DIGIT SUM CHALLENGE.MAIN
        /*int sum = sumDigits(495872);
        if ( sum == -1){
            System.out.println("Invalid Value");
        }else {
            System.out.println("Sum of digits = " + sum);
        }*/
    }
    //EVEN NUMBER CHECKER
    public static boolean isEvenNumber (int number){

        if ( number % 2 == 0 ){
            return true;
        }else
            return false;
    }

    //INTEREST CALCULATOR
    public static double calculateInterest(double amount, double doubleerestRate){
        return ((amount * doubleerestRate) / 100);
    }

    //PRIME NUMBER CHECKER
    public static boolean isPrime(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //TEEN NUMBER CHECKER.METHOD
    public static boolean hasTeen(int n1, int n2, int n3){

        if( ( n1 >= 13 && n1 <= 19) || ( n2 >= 13 && n2 <= 19) || ( n3 >= 13 && n3 <= 19 )){
            return true;
        }
        return false;
    }

    //DIGIT SUM CHALLENGE.METHOD
    public static int sumDigits( int number ){
        int sum = 0;
        int digit = 0;
        if ( number >= 10){
            while ( number > 0){
                digit = number % 10;
                sum += digit;
                number  = number / 10;
            }
            return sum;
        }else {
            return -1;
        }
    }
}