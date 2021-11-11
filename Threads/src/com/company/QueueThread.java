package com.company;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.QueueThread.EOF;

public class QueueThread {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        MyProducer myProducer = new MyProducer(buffer,ThreadColour.ANSI_BLUE);
        MyConsumer myConsumer1 =new MyConsumer(buffer, ThreadColour.ANSI_GREEN);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN);

        executor.execute(myProducer);
        executor.execute(myConsumer1);
        executor.execute(myConsumer2);

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

class MyProducer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + ThreadColour.ANSI_BOLD + num + ThreadColour.ANSI_RESET);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was Interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            //Empty block
        }
    }


}

class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while(true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    //Empty block
                }
            }
        }
    }
}







