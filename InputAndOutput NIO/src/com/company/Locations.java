package com.company;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();

    static {
/*
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");

        try (Scanner locFile = new Scanner(Files.newBufferedReader(locPath));
             Scanner dirFile = new Scanner(Files.newBufferedReader(dirPath))) {

            while (locFile.hasNextLine()) {
                String data[] = locFile.nextLine().split(",");
                int locID = Integer.parseInt(data[0]);
                String description = data[1];
                locations.put(locID, new Location(locID, description, null));
            }

            while (dirFile.hasNextLine()) {
                String data[] = dirFile.nextLine().split(",");
                int locId = Integer.parseInt(data[0]);
                String direction = data[1];
                int location = Integer.parseInt(data[2]);
                locations.get(locId).addExit(direction, location);
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
*/

        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationId(), location);
                } catch (EOFException e) {
                    System.out.println("End of file");
                    eof = true;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException" + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

/*
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");

        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {

            for (Location location : locations.values()) {
                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
*/

        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
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
