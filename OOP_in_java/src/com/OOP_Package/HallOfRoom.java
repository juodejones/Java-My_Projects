package com.OOP_Package;

public class HallOfRoom {

    private WallOfRoom wall;
    private FloorOfRoom floor;
    private CeilingOfRoom ceiling;


    public WallOfRoom getWall() {
        System.out.println(wall.getObj1() + "\t" + wall.getObj2() + "\t" +  wall.getObj3());
        return wall;
    }

    public FloorOfRoom getFloor() {
        System.out.println(floor.getObj1() + "\t" + floor.getObj2() + "\t" +  floor.getObj3());
        return floor;
    }

    public CeilingOfRoom getCeiling() {
        System.out.println(ceiling.getObj1() + "\t" + ceiling.getObj2());
        return ceiling;
    }


    public HallOfRoom(WallOfRoom wall, FloorOfRoom floor, CeilingOfRoom ceiling) {
        this.wall = wall;
        this.floor = floor;
        this.ceiling = ceiling;
    }

    public void hideObject(String object) {
        System.out.println("Hiding " + object + " in the hall...");
        if ((object.equals(floor.getObj1())) || (object.equals(floor.getObj2())) || (object.equals(floor.getObj3()))) {
            floor.hideObject(object);
        } else if ((object.equals(wall.getObj1())) || (object.equals(wall.getObj2())) || (object.equals(wall.getObj3()))) {
            wall.hideObject(object);
        } else if ((object.equals(ceiling.getObj1())) || (object.equals(ceiling.getObj2()))) {
            ceiling.hideObject(object);
        } else {
            System.out.println("Object was not found in the room!");
        }
    }
}
