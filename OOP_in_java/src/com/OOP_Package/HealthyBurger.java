package com.OOP_Package;

public class HealthyBurger extends Hamburger{

    private String healthyExtraName1, healthyExtraName2;
    private double healthyExtraPrice1, healthyExtraPrice2;

    public HealthyBurger(String meat, String breadRollType, double price) {
        super("Healthy", meat, breadRollType, price);
    }

    public void addHealthyAddition1(String healthyExtraName1, double healthyExtraPrice1) {
        super.addHamburgerAddition1(healthyExtraName1, healthyExtraPrice1);
    }

    public void addHealthyAddition2(String healthyExtraName2, double healthyExtraPrice2) {
        super.addHamburgerAddition2(healthyExtraName2, healthyExtraPrice2);
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }
}
