package com.jones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {

    public static void main(String[] args) {

        String challenge1 = "I want a Bike.";
        System.out.println(challenge1.matches("I want a Bike."));

        String regex1 = "I want a \\w+.";
        String challenge2 = "I want a Ball.";
        System.out.println(challenge1.matches(regex1));
        System.out.println(challenge2.matches(regex1));

        String regex2 = "I want a (Bike|Ball).";
        System.out.println(challenge1.matches(regex2));
        System.out.println(challenge2.matches(regex2));

        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        System.out.println("Challenge 7");
        System.out.println(challenge7.matches("^[A-Za-z]*\\.\\d+"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);

        System.out.println("Challenge 8");
        while (matcher8.find()) {
            System.out.println("Occurrence : " + matcher8.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        System.out.println("Challenge 9");
        while (matcher9.find()) {
            System.out.println("Occurrence : " + matcher9.start(1) +
                    " to " + (matcher9.end(1)-1));
        }

        String challenge11 = "{0,2}, {0,5}, {1,3}, {2,4}";
//        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Pattern pattern11 = Pattern.compile("\\{(\\d+,\\d+)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()) {
            System.out.println("Occurrence : " + matcher11.group(1));
        }

        String challenge12 = "11111";
        System.out.println("Challenge 12");
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println("Challenge 13");
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        System.out.println("Challenge 14");
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));

    }

}
