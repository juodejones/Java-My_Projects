package com.OOP_Package;

public class Room {

    private String roomType;
    private String room;
    private HallOfRoom hall;

    public Room(String roomType) {
        this.roomType = roomType;
    }

    public void hideObject(String object) {
        room = roomType.toLowerCase();
        if (room.equals("hall")) {
            System.out.println("Entering into Hall...");
            hall.hideObject(object);
        } else {
            System.out.println("Room not present!");
        }
    }

    public String getRoomType() {
        return roomType;
    }
}
