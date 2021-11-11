package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();

    static {
/*
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
*/
        try {
            bufferedReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

//        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
//                for (String exit : location.getExits().keySet()) {
//                    dirFile.write(location.getLocationId() + "," + exit + "," + location.getExits().get(exit) + "\n");
//                }
//            }
//        }

/*
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationId());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationId() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size()-1) + " exits...");
                locFile.writeInt(location.getExits().size()-1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equals("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
*/

        try(ObjectOutputStream locFile = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("locationsAsObject.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    public static void bufferedReader() throws IOException {
//        try (Scanner locFile = new Scanner(new BufferedReader(new FileReader("locations.txt")));
//             Scanner dirFile = new Scanner(new BufferedReader(new FileReader("directions.txt")))) {
//
//            while (locFile.hasNextLine()) {
//                String data[] = locFile.nextLine().split(",");
//                int locID = Integer.parseInt(data[0]);
//                String description = data[1];
//                locations.put(locID, new Location(locID, description, null));
//            }
//
//            while (dirFile.hasNextLine()) {
//                String data[] = dirFile.nextLine().split(",");
//                int locId = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int location = Integer.parseInt(data[2]);
//                locations.get(locId).addExit(direction, location);
//            }
//        }

/*
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(
                new FileInputStream("locations.dat")))) {

            boolean eof = false;
            while (!eof) {
                try {
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int numExits = locFile.readInt();
                    System.out.println("Reading location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0 ;  i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + ", " + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }
*/

        try (ObjectInputStream locFile = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("locationsAsObject.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Reading location " + location.getLocationId()
                            + " : " + location.getDescription());
                    System.out.println("Getting " + location.getExits().size() + " exits");
                    locations.put(location.getLocationId(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (ClassNotFoundException cf) {
            System.out.println("ClassNotFoundException" + cf.getMessage());
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.get(put(key, value));
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
