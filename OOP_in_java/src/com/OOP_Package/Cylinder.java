package com.OOP_Package;

public class Cylinder extends Circle {

    private double height;

    public double getHeight() {
        return height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getVolume() {
        return ( height * getArea() );
    }
}
