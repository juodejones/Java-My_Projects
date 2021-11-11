package com.company;

public class MultipleThreads {

    public static void main(String[] args) {

        CountDown count = new CountDown();

        CountDownThread t1 = new CountDownThread(count);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(count);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class CountDown {

    private int i;

    public void doCountDown() {

        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColour.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColour.ANSI_PURPLE;
                break;
            default:
                color = ThreadColour.ANSI_GREEN;
        }

        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread{

    private CountDown threadCountDown;

    public CountDownThread(CountDown threadCountDown) {
        this.threadCountDown = threadCountDown;
    }

    @Override
    public void run() {
        threadCountDown.doCountDown();
    }
}
















