package com.company;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.ProducerConsumer.EOF;

public class ProducerConsumer {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Producer producer = new Producer(buffer,ThreadColour.ANSI_BLUE, bufferLock);
        Consumer consumer1 =new Consumer(buffer, ThreadColour.ANSI_GREEN,bufferLock);
        Consumer consumer2 = new Consumer(buffer, ThreadColour.ANSI_CYAN, bufferLock);

        executor.execute(producer);
        executor.execute(consumer1);
        executor.execute(consumer2);

        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColour.ANSI_RESET + "This is being printed for the callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        executor.shutdown();
    }
}

class  Producer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Producer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock =  bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + ThreadColour.ANSI_BOLD + num + ThreadColour.ANSI_RESET);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was Interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }


}

class Consumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;
    private int counter = 0;

    public Consumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while(true) {
            if(bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println("The counter = " + counter);
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}







