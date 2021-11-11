package com.OOP_Package;

public class CeilingOfRoom {

    private String obj1, obj2;

    public CeilingOfRoom(String obj1, String obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public String getObj1() {
        return obj1;
    }

    public String getObj2() {
        return obj2;
    }

    public void hideObject(String object) {
        System.out.println("Hiding " + object + " in the Ceiling...");
        if (object.equals(obj1)) {
            this.obj1 = "No object";
        } else if (object.equals(obj2)) {
            this.obj2 = "No object";
        }
        System.out.println(object + " is hidden from the Ceiling.");
    }
}
