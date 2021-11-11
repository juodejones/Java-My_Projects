package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) {
        adventureGame();
    }

    public static void adventureGame() {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("OUT", "Q");
        vocabulary.put("QUIT", "Q");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                System.out.println("Exiting the game...");
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String i : exits.keySet())
                System.out.print(i + ",");
            System.out.println();
            String action = scanner.nextLine().toUpperCase();
            if (action.length() > 1) {
                String[] words = action.split(" ");
                for (String i : words) {
                    if (vocabulary.containsKey(i)) {
                        action = vocabulary.get(i);
                        break;
                    }
                }
            }
            if (exits.containsKey(action)) {
                if (action.equals("Q")) {
                    System.out.println("Quitting the game");
                } else {
                    for (Map.Entry<String, String> i : vocabulary.entrySet()) {
                        if (action.equals(i.getValue()))
                            System.out.println("Going " + i.getKey());
                    }
                }
                loc = exits.get(action);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
    }
}