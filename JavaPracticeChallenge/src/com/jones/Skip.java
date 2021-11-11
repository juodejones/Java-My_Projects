package com.jones;

import java.util.Scanner;

public class Skip {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isAddress = false;
        System.out.println("Enter number of address:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] ipArray  =  new String[n];
        for (int i = 0 ; i < ipArray.length ; i++){
            ipArray[i] = scanner.nextLine();
        }
        for (int i = 0; i < ipArray.length; i++) {
            String tempArray[] = ipArray[i].split(".");
            for (int j = 0; j < 3; j ++) {
                System.out.println(tempArray[j]);
                int value = Integer.parseInt(tempArray[j]);
                if(value >= 0 && value <= 255) {
                    isAddress = true;
                } else {
                    isAddress = false;
                }
            }
            System.out.println(isAddress);
        }
    }

}
