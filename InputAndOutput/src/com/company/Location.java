package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Location implements Serializable {

    public final int locationId;
    public final String description;
    public final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if (exits == null) {
            this.exits = new HashMap<>();
        } else {
            this.exits = new HashMap<>(exits);
        }
        this.exits.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public boolean addExit(String direction, int location) {
        exits.put(direction, location);
        return true;
    }
}
