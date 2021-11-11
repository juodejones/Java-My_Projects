package com.practice_package;

public class Main {

    public static void main(String[] args) {
//        int myminintvalue = -2147483648;
//        int mymaxintvalue = 2147483647;
//        System.out.println("Integer Minimum value=" + myminintvalue);
//        System.out.println("Integer Maximum value=" + mymaxintvalue);
//        byte myminbytevalue = 127;
//        byte mymaxbytevalue = -128;
//        System.out.println("Byte Minimum Value=" + myminbytevalue);
//        System.out.println("Byte Maximum Value=" + mymaxbytevalue);
//        short myminshortvalue = 32767;
//        short mymaxshortvalue = -32768;
//        System.out.println("Short Minimum Value=" + myminshortvalue);
//        System.out.println("Short Maximum Value=" + mymaxshortvalue);
//        long mylongvalue = 100L;
//        long myminlongvalue = 9223372036854775807L;
//        long mymaxlongvalue = -9223372036854775808L;
//        System.out.println("Long Minimum Value=" + myminlongvalue);
//        System.out.println("Long Maximum Value=" + mymaxlongvalue);
//        System.out.println("My long value is" + mylongvalue);
//        byte mynewbytevalue = (byte) (myminbytevalue / 2);
//        System.out.println(mynewbytevalue);
//        short myNewShortValue = (short) (myminshortvalue / 2);
//        System.out.println(myNewShortValue);
//        float myminfloatvalue = Float.MIN_VALUE;
//        float mymaxfloatvalue = Float.MAX_VALUE;
//        System.out.println("Float Minimum Value=" + myminfloatvalue);
//        System.out.println("Float Maximum Value=" + mymaxfloatvalue);
//        double mymindoublevalue = Double.MIN_VALUE;
//        double mymaxdoublevalue = Double.MAX_VALUE;
//        System.out.println("Double Minimum Value=" + mymindoublevalue);
//        System.out.println("Double Maximum Value=" + mymaxdoublevalue);
//
//       int myIntValue = 5 / 2;
//       float myFloatValue = 5f / 3f;
//       double myDoubleValue = 5d / 3d;
//       System.out.println("MyIntValue" + myIntValue);
//       System.out.println("MyFloatValue" + myFloatValue);
//       System.out.println("MyDoubleValue" + myDoubleValue);
//
//        double numberOfPounds = 200d;
//        double convertedKilograms = numberOfPounds * 0.45359237d;
//        System.out.println("Converted Kilograms=" + convertedKilograms);
//
//        double pi = 3.1415927d;
//        double anotherNumber = 3_000_000.4567890d;
//        System.out.println(pi);
//        System.out.println(anotherNumber);
//
//        char mychar = 'D';
//        char myUnicodeChar = '\u0044';
//        System.out.println(mychar);
//        System.out.println(myUnicodeChar);
//        char myCopyrightChar = '\u00A9';
//        System.out.println(myCopyrightChar);
//
//        int result = 1;
//        System.out.println("result = " + result);
//        // result = result + 1
//        result++;// 1+1=2
//        System.out.println("1 + 1" + result);
//        result += 2;//2+2=4
//        System.out.println("2+2+" + result);
//
//        //if-then statement
//        boolean isAlien = false;
//        if (!isAlien) {
//            System.out.println("It is not an alien!");
//            System.out.println("And I am scared of aliens");
//        }
//
//        boolean isCar = false;
//        if (isCar) {
//            System.out.println("This is not supposed to be done");
//        }
//
//        int topScore = 80;
//        if (topScore == 100) {
//            System.out.println("You got the high score!");
//        }
//
//        int secondTopscore = 60;
//        if ((topScore > secondTopscore) && (topScore < 100))
//            System.out.println("Greater than second top score and less than 100");
//
//        if ((topScore > secondTopscore) || (topScore < 100))
//            // Either or both of the conditions are true
//            System.out.println("Greater than second top score or less than 100");
//
//        double firstValue = 20.00d;
//        double secondValue = 80.00d;
//        double step3Value = (firstValue + secondValue) * 100d;
//        System.out.println("Step 3 Value is " + step3Value);
//        double remainder = step3Value % 40.00d;
//        System.out.println("The remainder value is " + remainder);
//        boolean isNoRemainder = (remainder == 0) ? true : false;
//        System.out.println("There is no remainder = " + isNoRemainder);
//        if (!isNoRemainder) {
//            System.out.println("Got some remainder");
//        }
//
//        boolean gameover = true;
//        //first score program
//        int score = 800;
//        int levelCompleted = 5;
//        int bonus = 100;
//
//        if (score < 5000 && score > 1000){
//            System.out.println("Your score is less than 5000 but greater than 1000");
//        }else if (score < 1000){
//            System.out.println("Your score is less than 1000");
//        }else{
//            System.out.println("Got here");
//        }
//
//        if(gameover){
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score is " + finalScore);
//        }
//
//        //Second score practice program
//        int newScore = 10000;
//        int newLevelCompleted = 8;
//        int newBonus = 200;
//
//        if (newScore < 5000 && newScore > 1000){
//            System.out.println("Your newScore is less than 5000 but greater than 1000");
//        }else if (newScore < 1000){
//            System.out.println("Your newScore is less than 1000");
//        }else{
//            System.out.println("Got here");
//        }
//
//        if(gameover){
//            int finalScore = newScore + (newLevelCompleted * newBonus);
//            System.out.println("Your final score is " + finalScore);
//        }
//        //This can also be done as
//        score = 10000;
//        levelCompleted = 8;
//        bonus = 200;
//
//        if(gameover){
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score is " + finalScore);
//        }
//
//    }
//
//        int highScore = calculateScore(true,800,5,100);
//        System.out.println("Your Score is " + highScore);
//        int newHighScore = calculateScore(true,10000,8,200);
//        System.out.println("New High Score is +" + newHighScore);
//        int highScorePosition = calculateHighScorePosition(1500);
//        displayHighScorePosition("Juode" , highScorePosition);
//        highScorePosition = calculateHighScorePosition(900);
//        displayHighScorePosition("Jones" , highScorePosition);
//        highScorePosition = calculateHighScorePosition(400);
//        displayHighScorePosition("Jeni" , highScorePosition);
//        highScorePosition = calculateHighScorePosition(50);
//        displayHighScorePosition("Aalya" , highScorePosition);

        //PARSING VALUES FROM A STRING AS INTEGER
        /*String numberAsString = "2018";
        System.out.println(" numberAsString " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        System.out.println(" number = " + number);

        numberAsString += 1;
        number += 1;

        System.out.println(" numberAsString " + numberAsString);
        System.out.println(" number = " + number);*/

        //PARSING VALUES FROM A STRING AS DOUBLE
        /*String numberAsString = "2018.354";
        System.out.println(" numberAsString " + numberAsString);

        double number = Double.parseDouble(numberAsString);
        System.out.println(" number = " + number);

        numberAsString += 1;
        number += 1;

        System.out.println(" numberAsString " + numberAsString);
        System.out.println(" number = " + number);*/
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
/*        if (score < 5000 && score > 1000){
            System.out.println("Your score is less than 5000 but greater than 1000");
        }else if (score < 1000){
            System.out.println("Your score is less than 1000");
        }else{
            System.out.println("Got here");
        }*/

        /*if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            return finalScore;
        }*/
        return -1;
    }

    public static void displayHighScorePosition(String playerName , int position){
        System.out.println(playerName + " managed to get into position " + position + " on the high score table!");
    }

    public static int calculateHighScorePosition(int playerScore){
/*        if (playerScore >= 1000){
            return 1;
        }else if (playerScore >= 500){
            return 2;
        }else if (playerScore >= 100){
            return 3;
        }
        return 4;*/
        int position = 4; //assuming position 4 will be returned
/*
        if (playerScore >= 1000){
            position = 1;
        }else if (playerScore >= 500){
            position = 2;
        }else if (playerScore >= 100){
            position = 3;
        }*/
        return position;
    }
}
