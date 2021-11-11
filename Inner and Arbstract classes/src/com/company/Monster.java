package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISavable {

    private String name;
    private int strength, hitPoints;

    public Monster(String name, int strength, int hitPoints) {
        this.name = name;
        this.strength = strength;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" +hitPoints);
        values.add(2, "" + strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        this.name = savedValues.get(0);
        this.hitPoints = Integer.parseInt(savedValues.get(1));
        this.strength = Integer.parseInt(savedValues.get(2));
    }
}
