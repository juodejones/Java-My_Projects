package com.jones;

import java.util.concurrent.locks.ReentrantLock;

public class AccountHolder extends Thread {

    private String name;
    private BankAccount account;
    private double deposit, withdrawl;
    private static ReentrantLock lock = new ReentrantLock();

    public AccountHolder(String name, BankAccount bankAccount) {
        this.name = name;
        this.account = bankAccount;
    }

    public synchronized void transact(double deposit, double withdrawal) {
        this.deposit = deposit;
        this.withdrawl = withdrawal;
    }

    @Override
    public void run() {
//        try {
//            lock.lock();
            System.out.println("Depositing in " + Thread.currentThread().getName());
            account.deposit(deposit);
            System.out.println("Withdrawing in " + Thread.currentThread().getName());
            account.withdraw(withdrawl);
//        }finally {
//            lock.unlock();
//        }
    }
}
