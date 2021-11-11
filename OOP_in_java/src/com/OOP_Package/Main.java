package com.OOP_Package;

public class Main{

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Basic", "Sausage", "White", 3.56);
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is $" + String.format("%.2f",hamburger.itemizeHamburger()));

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", "Brown rye", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        System.out.println("Total Healthy Burger price is  $" + String.format("%.2f",healthyBurger.itemizeHamburger()));

        DeluxeBurger db = new DeluxeBurger(hamburger.getMeat() + healthyBurger.getMeat(),"White");
        db.addHamburgerAddition3("Should not do this", 50.53);
        System.out.println("Total Deluxe Burger price is $" + String.format("%.2f",db.itemizeHamburger()));
    }
}

/*
class CarA {
    private int engineCapacity, noOfCylinders, wheels, speed = 0;
    private String nameOfCar;

    public CarA(String nameOfCar, int engineCapacity, int noOfCylinders, int wheels) {
        this.nameOfCar = nameOfCar;
        this.engineCapacity = engineCapacity;
        this.noOfCylinders = noOfCylinders;
        this.wheels = wheels;
    }

    public void startEngine(boolean isStart) {
        if (isStart) {
            System.out.println(this.nameOfCar + " engine is started....");
        } else {
            System.out.println(this.nameOfCar + " engine is off...");
        }
    }

    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Car is moving at " + speed + "km/hr");
        if (this.speed < 0) {
            System.out.println("The car is decelerating");
        }
    }

    public void applyBrake(boolean isApply) {
        if (isApply) {
            System.out.println("Brake applied");
            System.out.println("Car is slowing down...");
            System.out.println("Car has been stopped.");
        }
    }


    public int getEngineCapacity() {
        return engineCapacity;
    }

    public int getNoOfCylinders() {
        return noOfCylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }
}

class Fortuner extends CarA{

   public Fortuner(){
       super("Fortuner",1998,4,4);
   }

    @Override
    public void startEngine(boolean isStart) {
        super.startEngine(isStart);
    }

    @Override
    public void accelerate(int speed) {
        super.accelerate(speed);
    }

    @Override
    public void applyBrake(boolean isApply) {
        super.applyBrake(isApply);
    }
}

class Indica extends CarA{

    public Indica(){
        super("Indica",1998,4,4);
    }

    @Override
    public void startEngine(boolean isStart) {
        super.startEngine(isStart);
    }

    @Override
    public void accelerate(int speed) {
        super.accelerate(speed);
    }

    @Override
    public void applyBrake(boolean isApply) {
        super.applyBrake(isApply);
    }
}

class Mustang extends CarA{

    public Mustang(){
        super("Mustang",5798,6,4);
    }

    @Override
    public void startEngine(boolean isStart) {
        super.startEngine(isStart);
    }

    @Override
    public void accelerate(int speed) {
        super.accelerate(speed);
    }

    @Override
    public void applyBrake(boolean isApply) {
        super.applyBrake(isApply);
    }
}
*/










