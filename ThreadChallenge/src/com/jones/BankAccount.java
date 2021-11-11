package com.jones;

public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {

        if (amount > this.balance) return false;
        balance -= amount;
        return true;
    }
}
