package com.company;

import static com.company.ThreadColour.*;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from " + currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread interrupted me!");
            return;
        }

        System.out.println(ANSI_BLUE + "Thread running after three seconds");
    }
}