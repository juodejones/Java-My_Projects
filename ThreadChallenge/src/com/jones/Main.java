package com.jones;

public class Main {

    public static void main(String[] args) {
        final BankAccount account = new BankAccount("28411101008928", 1000);
//        AccountHolder person1 = new AccountHolder("Person1", account);
//        AccountHolder person2 = new AccountHolder("Person2", account);
//        person1.setName("Thread-1");
//        person2.setName("Thread-2");
//        person1.transact(300.00, 50.00);
//        person2.transact(203.75, 100.00);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account){
                System.out.println("Depositing in " + Thread.currentThread().getName());
                account.deposit(300);
                System.out.println("Withdrawing in " + Thread.currentThread().getName());
                account.withdraw(50);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account){
                    System.out.println("Depositing in " + Thread.currentThread().getName());
                    account.deposit(203.75);
                    System.out.println("Withdrawing in " + Thread.currentThread().getName());
                    account.withdraw(100);
                }
            }
        });

        t1.start();
        t2.start();

    }


}
