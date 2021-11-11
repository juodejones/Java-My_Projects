package com.company;

import java.util.*;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new LinkedHashSet<>();
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        stockChallengeMain();
    }

    public static void adventureGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================================================");

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("QUIT", "Q");

        int loc = 1;
        while (true) {
            if (loc == 0) {
                System.out.println("Exiting the game...");
                System.out.println("======================================================================");
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println(locations.get(loc).getDescription());
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
                loc = exits.get(action);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
/*
        boolean valid = true;
        boolean exit = false;
        while (!exit) {
            valid = true;
            Location currentLocation = locations.get(loc);
            System.out.println(currentLocation.getDescription());
            System.out.print("Availabe exits are ");
            for (String i : currentLocation.getExits().keySet()) {
                System.out.print(i + ",");
            }
            System.out.println();
            System.out.println("What do you want to do?");
            String[] actions = scanner.nextLine().toUpperCase().split(" ");
            for (String i : actions) {
                valid = true;
                for (String j : vocabulary.keySet()) {
                    if (i.equals(j)) {
                        if (currentLocation.getExits().containsKey(vocabulary.get(j))) {
                            loc = currentLocation.getExits().get(vocabulary.get(j));
                            valid = true;
                            break;
                        } else {
                            valid = false;
                            exit = true;
                        }
                    } else {
                        for (String k : currentLocation.getExits().keySet()) {
                            if (i.equals(k)) {
                                loc = currentLocation.getExits().get(k);
                                valid = true;
                                break;
                            } else {
                                valid = false;
                                loc = 0;
                                exit = true;
                            }
                        }
                    }
                }
            }
        }
        if (loc == 0) {
            if (!valid) {
                System.out.println("You can't go in that direction.");
            }
            System.out.println(locations.get(0).getDescription());
            System.out.println("Exiting the game...");
            System.out.println("======================================================================");
        }
*/
    }

    public static void heavenlyBodyMain() {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey().getName());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyType.PLANET));
        System.out.println("Moons of " + body.getKey().getName());

        for(HeavenlyBody marsMoon: body.getSatellites()) {
            System.out.println("\t" + marsMoon.getKey().getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey().getName());
        }

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        if (!solarSystem.containsKey(pluto.getKey())) {
            solarSystem.put(pluto.getKey(), pluto);
        }
        planets.add(pluto);

        System.out.println("The planets are");
        for (HeavenlyBody planet : planets)
            System.out.println(planet);
        System.out.println("The moons are");
        for (HeavenlyBody moon : moons)
            System.out.println(moon);

//        HeavenlyBody earth1 = new Planet("Earth", 365);
//        HeavenlyBody earth2 = new Planet("Earth", 365);
//        System.out.println(earth1.equals(earth2));
//        System.out.println(earth2.equals(earth1));
//        System.out.println(earth1.equals(pluto));
//        System.out.println(pluto.equals(earth1));

        System.out.println("Finally, \nThe Solar System contains : ");
        for ( HeavenlyBody heavenlyBody : solarSystem.values())
            System.out.println(heavenlyBody);

        body = solarSystem.get(HeavenlyBody.makeKey("Earth", HeavenlyBody.BodyType.PLANET));

    }

    public static void stockChallengeMain() {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket = new Basket("|Brown|");
        checkOut(basket);
        basket.addToBasket(stockList.get("Phone"), 3);
        basket.addToBasket(stockList.get("Cup"), 15);
        basket.addToBasket(stockList, "Juice", 4);
        basket.addToBasket(stockList, "Door", 4);
        basket.addToBasket(stockList, "Car", 5);

        sellItem(basket, "Towel", 3);

        System.out.println(basket);
        basket.addToBasket(stockList.get("Cup"), 2);
        System.out.println(stockList.get("Cup"));
        basket.removeItem(stockList.get("Phone"), 1);
        basket.removeItem(stockList.get("Door"), 6);
        basket.sortBasket("Price", "asc");
        System.out.println(basket);

        checkOut(basket);
        System.out.println(stockList);
        stockList.sortList("quantity", "descending");
        System.out.println(stockList);

    }

    public static int sellItem(Basket basket,String item, int quantity){

        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell the item.");
            return 0;
        }
        return basket.addToBasket(stockItem, quantity);
    }

    public static void checkOut(Basket basket) {
        if (basket.getItems().isEmpty()) {
            System.out.println("Nothing in the Basket.\n");
        } else {
            for (Map.Entry<StockItem, Integer> item : basket.getItems().entrySet()){
                StockItem currentItem = item.getKey();
                stockList.sellStock(currentItem.getName(), currentItem.getReservedStock());
            }
            basket.checkOut();
        }
    }
}
