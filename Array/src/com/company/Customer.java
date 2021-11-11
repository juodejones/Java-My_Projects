package com.company;

import java.util.ArrayList;

public class Customer {

    public String customerName;
    ArrayList<Double> transactions;

    public Customer(String customerName, double initialAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
        addTransactions(initialAmount);
    }

    public void addTransactions(double amount) {
        this.transactions.add(amount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
