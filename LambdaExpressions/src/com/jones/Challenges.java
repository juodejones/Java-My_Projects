package com.jones;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Challenges {

    public static void main(String[] args) {
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split up this into an array";
                String[] parts = myString.split(" ");
                for (String part : parts){
                    System.out.println(part);
                }
            }
        };*/

        // This can be written as

        Runnable runnable = () -> {
          String myString = "Let's split up this into an array";
          for (String part : myString.split(" "))
              System.out.println(part);
        };

        Function<String, String > lambda = (String s) -> {
            StringBuilder val = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i%2 == 1) val.append(s.charAt(i));
            }
            return val.toString();
        };

//        System.out.println(lambda.apply("1234567890"));
        System.out.println(everySecondCharacter(lambda, "1234567890"));

//        Supplier<String> iLoveJava = () -> "I Love Java";
        Supplier<String> iLoveJava = () -> {return "I Love Java";};

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        topNames2015.stream()
                .map(name -> (name.substring(0,1)).toUpperCase())
                .peek(System.out::println)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println("Number of Names starting with 'A'" +topNames2015.stream()
                .map(name -> (name.substring(0,1)).toUpperCase())
                .filter(name -> name.startsWith("A"))
                .count());

    }

    public static String everySecondCharacter(Function<String, String> function, String source) {
        return function.apply(source);
    }
}



