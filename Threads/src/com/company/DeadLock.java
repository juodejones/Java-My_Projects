package com.company;

public class DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

    }
    
    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 : Has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //Empty block
                }
                System.out.println("Thread 1 : waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1 : has lock 1 and lock 2");
                }
                System.out.println("Thread 1 : released lock 2");
            }
            System.out.println("Thread 1 : released lock 1");
        }
    }
    
    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 : Has lock 2");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    //Empty block
                }
                System.out.println("Thread 2 : waiting for lock 1");
                synchronized (lock1) {
                    System.out.println("Thread 2 : has lock 2 and lock 1");
                }
                System.out.println("Thread 2 : released lock 1");
            }
            System.out.println("Thread 2 : released lock 2");
        }
    }
}
