package com.OOP_Package;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger(String meat, String breadRollType) {
        super("Deluxe ", meat, breadRollType, 15);
        super.addHamburgerAddition1("Chips", 1.5);
        super.addHamburgerAddition2("Drink", 2.6);
    }

    @Override
    public void addHamburgerAddition1(String addition1Name, double addition1Price) {
        System.out.println("Cannot add extra additions to Deluxe Burger!");
    }

    @Override
    public void addHamburgerAddition2(String addition2Name, double addition2Price) {
        System.out.println("Cannot add extra additions to Deluxe Burger!");
    }

    @Override
    public void addHamburgerAddition3(String addition3Name, double addition3Price) {
        System.out.println("Cannot add extra additions to Deluxe Burger!");
    }

    @Override
    public void addHamburgerAddition4(String addition4Name, double addition4Price) {
        System.out.println("Cannot add extra additions to Deluxe Burger!");
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }
}
