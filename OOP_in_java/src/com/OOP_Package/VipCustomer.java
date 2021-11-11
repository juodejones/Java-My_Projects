package com.OOP_Package;

public class VipCustomer {

    private String name;
    private String creditLimit;
    private String email;

    public VipCustomer(){
        this.name = "Unknown Name";
        this.creditLimit = "5,00,000";
        this.email = "unknown@gmail.com";
    }

    public VipCustomer(String name, String creditLimit){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = "unknown@gmail.com";
    }

    public VipCustomer(String name, String creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
