package com.OOP_Package;

public class Hamburger {

    private String name, meat, breadRollType;
    private double price;
    private String addition1Name,addition2Name,addition3Name,addition4Name;
    private double addition1Price,addition2Price,addition3Price,addition4Price;

    public String getName() {
        return name;
    }

    public String getMeat() {
        return meat;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public double getPrice() {
        return price;
    }

    public Hamburger(String name, String meat, String breadRollType, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
        System.out.println(name + " hamburger with " + breadRollType + " with " + meat + ", price is $" + price);
    }

    public void addHamburgerAddition1(String addition1Name, double addition1Price) {
        this.addition1Name = addition1Name;
        System.out.println("Added " + addition1Name + " for and extra $" + String.format("%.2f",addition1Price));
        this.addition1Price = addition1Price;
        this.price += addition1Price;
    }
    
    public void addHamburgerAddition2(String addition2Name, double addition2Price) {
        this.addition2Name = addition2Name;
        System.out.println("Added " + addition2Name + " for and extra $" + String.format("%.2f",addition2Price));
        this.addition2Price = addition2Price;
        this.price += addition2Price;
    }
    
    public void addHamburgerAddition3(String addition3Name, double addition3Price) {
        this.addition3Name = addition3Name;
        System.out.println("Added " + addition3Name + " for and extra $" + String.format("%.2f",addition3Price));
        this.addition3Price = addition3Price;
        this.price += addition3Price;
    }
    
    public void addHamburgerAddition4(String addition4Name, double addition4Price) {
        this.addition4Name = addition4Name;
        System.out.println("Added " + addition4Name + " for and extra $" + String.format("%.2f",addition4Price));
        this.addition4Price = addition4Price;
        this.price += addition4Price;
    }

    public double itemizeHamburger() {
        return price;
    }
}
