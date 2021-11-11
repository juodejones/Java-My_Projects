package com.company;

public class SharedResource {

    private Worker owner;

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1" , true);
        final Worker worker2 = new Worker("Worker 2" , true);
        final SharedResource resource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(resource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(resource, worker1);
            }
        }).start();
    }

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
