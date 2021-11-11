package com.OOP_Package;

public class Point {
    int x, y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x, int y){
        return Math.sqrt((this.x - x)*(this.x - x) + (this.y-y)*(this.y-y));
    }

    public double getDistance() {
        return getDistance(0,0);
    }

    public double getDistance(Point point){
        return getDistance(point.x,point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
