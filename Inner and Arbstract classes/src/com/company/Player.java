package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISavable{

    private String name, weapon;
    private int hitPoints, strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, weapon);
        values.add(2, "" + hitPoints);
        values.add(3, "" + strength);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {

        if (savedValues != null && savedValues.size() >= 0 ) {
            this.name = savedValues.get(0);
            this.weapon = savedValues.get(1);
            this.hitPoints = Integer.parseInt(savedValues.get(2));
            this.strength = Integer.parseInt(savedValues.get(3));
        }
    }
}
