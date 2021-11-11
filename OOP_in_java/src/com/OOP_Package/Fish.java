package com.OOP_Package;

public class Fish extends Animal{

    private int gills;
    private int fins;
    private int eyes;

    public Fish(String name, int size, int weight, int gills, int fins, int eyes) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.fins = fins;
        this.eyes = eyes;
    }

    public void rest() {

    }

    public void moveMuscles() {

    }

    public void moveBackFin() {

    }

    public void move(int speed){
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
