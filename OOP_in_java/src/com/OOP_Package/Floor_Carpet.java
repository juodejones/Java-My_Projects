package com.OOP_Package;

public class Floor_Carpet {
    private double width, height;

    public Floor_Carpet(double width, double height) {
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }

        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getArea() {
        return width * height;
    }
}

class Carpet{
    private double cost;

    public Carpet(double cost){
        if( cost < 0 ){
            this.cost = 0;
        } else {
            this.cost = cost;
        }
    }

    public double getCost() {
        return cost;
    }
}

class Calculator{
    private Floor_Carpet floor;
    private Carpet carpet;

    public Calculator(Floor_Carpet floor,Carpet carpet){
        this.floor = floor;
        this.carpet = carpet;
    }
    public double getTotalCost(){
        return floor.getArea()*carpet.getCost();
    }
}