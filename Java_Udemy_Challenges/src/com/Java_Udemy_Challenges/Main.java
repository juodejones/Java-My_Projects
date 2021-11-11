package com.Java_Udemy_Challenges;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
    }

    //BARKING DOG.METHOD
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {

        if ((hourOfDay < 0 || hourOfDay > 23) || !isBarking) {
            return false;
        } else if ((hourOfDay < 8 || hourOfDay > 22) && isBarking) {
            return true;
        }
        return false;
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

    //LEAP YEAR CHECK.METHOD
    public static boolean isLeapYear(int year) {

        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    //DECIMAL OPERATOR.METHOD
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {

        if ((int) (num1 * 1000) == (int) (num2 * 1000)) {
            return true;
        }
        return false;
    }

    //EQUAL SUM CHECKER.METHOD
    public static boolean hasEqualSum(int num1, int num2, int num3) {

        if (num1 + num2 == num3) {
            return true;
        }
        return false;
    }

    //AREA.METHOD
    public static double area(double radius) {

        if (radius >= 0) {
            double area = Math.PI * radius * radius;
            return area;
        }
        return -1.0;
    }

    public static double area(double x, double y) {

        if (x >= 0 && y >= 0) {
            double area = x * y;
            return area;
        }
        return -1.0;
    }

    //MINUTES TO YEARS AND DAYS CALCULATOR.METHOD
    public static void printYearsAndDays(long minutes) {
        if (minutes >= 0) {
            long days = minutes / 1440;
            long remainingMinutes = minutes % 1440;
            long years = days / 365;
            long remainingDays = days % 365;
            System.out.println(minutes + " min = " + years + "y and " + remainingDays + "d");
        } else {
            System.out.println("Invalid Value");
        }
    }

    //EQUALITY PRINTER.METHOD
    public static void printEqual(int num1, int num2, int num3) {
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println("Invalid Values");
        } else if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal");
        } else if (num1 != num2 && num2 != num3 && num1 != num3) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }

    //PLAYING CAT EXERCISE
    public static boolean isCatPlaying ( boolean isSummer, int temperature) {

        if ( isSummer && temperature >= 25 && temperature <= 45 ){
            return true;
        }else if ( temperature >= 25 && temperature <= 35){
            return true;
        }else{
            return false;
        }
    }

    //READING USER INPUT CHALLENGE
    public static void readingUserInput() {

        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int sum = 0;

        while (true) {
            int order = counter + 1;
            System.out.println("Enter the number #" + order + ":");

            boolean isAnInt = scanner.hasNextInt();

            if (isAnInt) {
                int number = scanner.nextInt();
                counter++;
                sum += number;
                if (counter == 10) {
                    break;
                }
            } else {
                System.out.println("Invalid Value");
            }
            scanner.nextLine();
        }
        System.out.println("The sum is " + sum);
        scanner.close();
    }

    //MIN AND MAX INPUT CHALLENGE
    public static void minAndMax() {

        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        int min = 0;
//        int max = 0;
//        boolean first = true;

        while (true) {
            System.out.println("Enter the number:");
            boolean isAnInt = scanner.hasNextInt();

            if (isAnInt) {

                int number = scanner.nextInt();

//                if (first){
//                    min = number;
//                    max = number;
//                    first = false;
//                }

                if (number > max) {
                    max = number;
                }

                if (number < min) {
                    min = number;
                }
            } else {
                break;
            }
            scanner.nextLine();
        }
        scanner.close();

        System.out.println("Minimum number is " + min);
        System.out.println("Maximum number is " + max);
    }

    //NUMBER PALINDROME CHALLENGE
    public static boolean palindromeCheck(int number) {

        int rev = 0;
        int digit;
        int temp = number;

        while (number > 0) {
            digit = number % 10;
            rev = (rev * 10) + digit;
            number /= 10;
            System.out.println(rev);
        }
        if (temp == rev) {
            return true;
        } else {
            return false;
        }
    }

    //FIRST AND LAST DIGIT
    public static void sumFirstAndLastDigit(int number) {
        int lastDigit = number % 10;

        while (number > 10) {
            number /= 10;
        }
        System.out.println("First digit is " + number);

        int sum = number + lastDigit;
        System.out.println("sum is " + sum);
    }

    //EVEN DIGIT SUM
    public static void evenDigitSum(int number) {
        int digit;
        int sum = 0;

        while (number > 0) {
            digit = number % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            number /= 10;
        }
        System.out.println("Sum is " + sum);
    }

    //SHARED DIGIT SUM
    public static boolean sharedDigit(int num1, int num2) {
        int digit1;
        int digit2;
        if ((num1 >= 10 && num2 >= 10) && (num1 <= 99 && num2 <= 99)) {
            while (num1 > 0 && num2 > 0) {
                digit1 = num1 % 10;
                digit2 = num2 % 10;
                num1 /= 10;
                num2 /= 10;
                if (digit1 == digit2) {
                    return true;
                } else if (digit1 == num2) {
                    return true;
                } else if (digit2 == num1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //GCD OF TWO NUMBERS
    public static int greatestCommonDivisor ( int num1, int num2) {

        int gcd = 1;
        if (num1 >= 10 && num2 >= 10){
            int min = Math.min(num1, num2);
            for ( int i=2; i<=min; i++){
                if ( (num1 % i == 0) && (num2 % i == 0)){
                    gcd = i;
                }
            }
            return gcd;
        }
        return -1;
    }

    //FACTORS OF A NUMBER
    public static int printFactors ( int number ){
        if (number > 0){
//            System.out.println("The factors of " + number + " are:");
            for ( int i =1;i<=number; i++) {
                if (number%i == 0) {
//                    System.out.println(i);
                    return i;
                }
            }
        }else{
//            System.out.println("Invalid value");
            return -1;
        }
        return -1;
    }

    //PERFECT NUMBER
    public static boolean isPerfectNumber ( int number ) {

        int sum = 0;
        for (int i =1;i<number; i++) {
            if (number%i == 0) {
                sum += i;
            }
        }
        if ( sum == number) {
            System.out.println(number + " is a perfect number!");
            return true;
        }
        System.out.println("Not a perfect number");
        return false;
    }

    //NUMBER TO WORDS
    public static void myNumberToWords ( int number) {

        if ( number < 0){
            System.out.println("Invalid value");
        }else {
            int temp = number;
            int reverse = reverseOfNumber(number);
            int digit;
            while ( reverse > 0 ) {
                digit = reverse % 10;
                reverse /= 10;
                if (digit == 0) {
                    System.out.println("Zero");
                }else if ( digit == 1){
                    System.out.println("One");
                }else if ( digit == 2){
                    System.out.println("Two");
                }else if ( digit == 3){
                    System.out.println("Three");
                }else if ( digit == 4){
                    System.out.println("Four");
                }else if ( digit == 5){
                    System.out.println("Five");
                }else if ( digit == 6){
                    System.out.println("Six");
                }else if ( digit == 7){
                    System.out.println("Seven");
                }else if ( digit == 8){
                    System.out.println("Eight");
                }else  {
                    System.out.println("Nine");
                }
            }
            for (int i = 0; i < getDigitCount(number); i++) {
                if (temp % 10 == 0) {
                    System.out.println("Zero");
                    temp /= 10;
                }
            }
        }
    }

    //NUMBER TO WORDS ANOTHER SOLUTION
    public static void myNumberToWords2 ( int number) {

        if ( number < 0){
            System.out.println("Invalid value");
        }else {
            int temp = number;
            int reverse = reverseOfNumber(number);
            int digit;
            for (int i = 0; i < getDigitCount(number); i++) {
                digit = reverse % 10;
                reverse /= 10;
                if (digit == 0) {
                    System.out.println("Zero");
                }else if ( digit == 1){
                    System.out.println("One");
                }else if ( digit == 2){
                    System.out.println("Two");
                }else if ( digit == 3){
                    System.out.println("Three");
                }else if ( digit == 4){
                    System.out.println("Four");
                }else if ( digit == 5){
                    System.out.println("Five");
                }else if ( digit == 6){
                    System.out.println("Six");
                }else if ( digit == 7){
                    System.out.println("Seven");
                }else if ( digit == 8){
                    System.out.println("Eight");
                }else  {
                    System.out.println("Nine");
                }
            }
        }
    }

    //NUMBER TO WORDS ANOTHER SOLUTION USING SWITCH STATEMENT
    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int reverseNumber = reverseOfNumber(number);
        for (int i = 0; i < getDigitCount(number); i++) {

            switch (reverseNumber % 10) {
                case 0:
                    System.out.print("Zero ");
                    break;
                case 1:
                    System.out.print("One ");
                    break;
                case 2:
                    System.out.print("Two ");
                    break;
                case 3:
                    System.out.print("Three ");
                    break;
                case 4:
                    System.out.print("Four ");
                    break;
                case 5:
                    System.out.print("Five ");
                    break;
                case 6:
                    System.out.print("Six ");
                    break;
                case 7:
                    System.out.print("Seven ");
                    break;
                case 8:
                    System.out.print("Eight ");
                    break;
                case 9:
                    System.out.print("Nine ");
                    break;
                default:
                    break;
            }
            reverseNumber /= 10;
        }

        System.out.println();
    }

    //REVERSE OF A NUMBER
    public static int reverseOfNumber ( int number) {
        int rev = 0;
        int digit;

        while (number > 0) {
            digit = number % 10;
            rev = (rev * 10) + digit;
            number /= 10;
        }
        return rev;
    }

    //DIGIT COUNT METHOD
    public static int getDigitCount ( int number ) {

        int digitCount = 0;
        while (number > 0 ) {
            number /= 10;
            digitCount++;
        }
        return digitCount;
    }

    //FLOUR PACK PROBLEM
    public static boolean isPack ( int bigCount, int smallCount, int goal) {

        int bigPackCheck = goal / 5;
        int remainingFlour = goal % 5;

        if ( (bigCount<0) || (smallCount<0) || (goal<0)){
            return false;
        }
        return (bigPackCheck >= bigCount && remainingFlour <= smallCount);
    }

    //LARGEST PRIME FACTOR OF A NUMBER
    public static int getLargestPrimeFactor ( int number) {

        int largestPrime = 0;
        for ( int i = 1; i <= number; i++ ) {
            if (number % i == 0) {
                if ( isPrime(i) ) {
                    if ( i > largestPrime){
                        largestPrime = i;
                    }
                }
            }
        }
        if (largestPrime >= 2) {
            return largestPrime;
        }else {
            return -1;
        }
    }

    //LARGEST PRIME FACTOR OF A NUMBER ONLINE SOLUTION
    public static int getLargestPrime (int number) {

        if(number < 2){
            return -1;
        }

        int i;

        for (i = 2; i <= number; i++) {
            if (number % i == 0) {
                number /= i;
                i--;
            }
        }
        return i;
    }

    public static void inputThenPrintSumAndAverage() {

        Scanner scanner = new Scanner(System.in);
        int order = 0;
        double sum = 0;

        while (order >= 0) {
            System.out.println("Enter number #" + (order+1) + ":");
            boolean hasInt = scanner.hasNextInt();

            if (hasInt) {
                int number = scanner.nextInt();
                sum += number;
                order++;
            } else {
                break;
            }
        }
        scanner.nextLine();
        System.out.println("SUM = " + String.format("%.2f", sum));

        double avg = sum / (order) ;
        System.out.println("AVG = " + String.format("%.2f", avg));
        scanner.close();
    }

    //PAINT JOB PROBLEM
    public static int getBucketCount ( double width, double height, double areaPerBucket, int extraBuckets ) {

        if ( width >= 0 && height >= 0 && areaPerBucket >= 0) {
            int requiredNumberOfBuckets = getBucketCount (width, height, areaPerBucket );
            int buyNumberOfBuckets = requiredNumberOfBuckets - extraBuckets;
//            System.out.println("Number of Buckets to buy = " + buyNumberOfBuckets);
            return buyNumberOfBuckets;
        }
        return -1;
    }

    public static int getBucketCount ( double width, double height, double areaPerBucket ) {

        if ( width >= 0 && height >= 0 && areaPerBucket >= 0) {
            double area = width * height;
//            System.out.println("Area = " + area);
//            System.out.println("Number of buckets to buy = " + getBucketCount(area, areaPerBucket) );
            return getBucketCount(area, areaPerBucket);
        }
        return -1;
    }

    public static int getBucketCount ( double area, double areaPerBucket) {
        if ( area >= 0 && areaPerBucket >= 0 ) {
            int requiredNumberOfBuckets = (int) Math.ceil(area / areaPerBucket);
//            System.out.println("Number of buckets to buy = " + requiredNumberOfBuckets );
            return requiredNumberOfBuckets;
        }
        return -1;
    }

    public static void paintBucketMain() {

        int result = getBucketCountMain();
        if (result >=0 ) {
            System.out.println("Number of Paint Buckets to buy =" + result);
        } else {
            System.out.println("Invalid choice");
        }
    }

    //MAIN PROGRAM OF GET BUCKET COUNT // BEST EVER UNTIL 13.04.2021(TUESDAY)!!!!
    public static int getBucketCountMain () {
        double width = 0;
        double height = 0;
        double area = 0;
        int extraBuckets = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you know the width and height(1) or the area(0) of the wall?");
        boolean intReply1 = scanner.hasNextInt();
        if (intReply1) {
            int reply1 = scanner.nextInt();
            if (reply1 == 1) {
                System.out.println("Enter the width of the wall :");
                width = scanner.nextDouble();
                System.out.println("Enter the height of the wall :");
                height = scanner.nextDouble();
                scanner.nextLine();
            } else if (reply1 == 0) {
                System.out.println("Enter the area of the wall :");
                area = scanner.nextDouble();
                scanner.nextLine();
            } else {
                return -1;
            }
            System.out.println("Enter the area covered by one bucket of paint :");
            double areaCovered = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Do you have extra buckets of paint ( 1(Yes) / 0(No) )?");
            boolean intReply2 = scanner.hasNextInt();
            if (intReply2) {
                int reply2 = scanner.nextInt();
                if (reply2 == 1 && reply1 == 1) {
                    System.out.println("Enter the number of extra buckets you have :");
                    extraBuckets = scanner.nextInt();
                    scanner.nextLine();
                    return getBucketCount(width, height, areaCovered, extraBuckets);
                } else if (reply2 == 1 && reply1 == 0) {
                    System.out.println("Enter the number of extra buckets you have :");
                    extraBuckets = scanner.nextInt();
                    scanner.nextLine();
                    return getBucketCount(area, areaCovered, extraBuckets);
                } else if (reply2 == 0 && reply1 == 1) {
                    return getBucketCount(width, height, areaCovered);
                } else if (reply2 == 0 && reply1 == 0) {
                    return getBucketCount(area, areaCovered);
                }
            }else {
                return -1;
            }
        }else {
            return -1;
        }
        scanner.close();
        return -1;
    }

    //DIAGONAL STAR PRINTING
    public static void printSquareStar() {
        int number;
        System.out.println("Enter the number of rows and columns :");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        if( number < 5){
            System.out.println("Invalid value!!");
            return ;
        }

        for ( int row = 1; row <= number; row++){
            for ( int col = 1; col <= number; col++) {
                if ( row == 1 || col == 1 ) {
                    System.out.print("*");
                }else if(row == col){
                    System.out.print("*");
                }else if(col== number-row +1){
                    System.out.print("*");
                }else if(row == number || col ==number){
                    System.out.print("*");
                }else{
                    System.out.print(' ');
                }
            }
            System.out.print('\n');

        }
    }

    public static void virusTest() {

        System.out.println("Enter the name of the virus:");
        String virus = scanner.nextLine();
        System.out.println("Enter the number of Patients:");
        int num = scanner.nextInt();
        scanner.nextLine();
        virus = virus.toLowerCase();
        LinkedList<Character> virusList = new LinkedList<>();
        for (char ch: virus.toCharArray()) {
            virusList.add(ch);
        }
        for (int i = 0; i < num; i++) {
            boolean flag = false;
            System.out.println("Enter the name of the virus:");
            String patientVirus = scanner.nextLine();
            for (char ch : patientVirus.toCharArray()) {
                if (virusList.contains(ch)) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("POSITIVE");
            } else {
                System.out.println("NEGATIVE");
            }
        }
    }
}