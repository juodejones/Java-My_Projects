package com.OOP_Package;

public class FloorOfRoom {

    private String obj1, obj2, obj3;

    public FloorOfRoom(String obj1, String obj2, String obj3) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public String getObj1() {
        return obj1;
    }

    public String getObj2() {
        return obj2;
    }

    public String getObj3() {
        return obj3;
    }

    public void hideObject(String object) {
        System.out.println("Hiding " + object + " in the floor...");
        if (object.equals(obj1)) {
            this.obj1 = "No object";
        } else if (object.equals(obj2)) {
            this.obj2 = "No object";
        } else if (object.equals(obj3)) {
            this.obj3 = "No object";
        }
        System.out.println(object + " is hidden from the floor.");
    }
}
