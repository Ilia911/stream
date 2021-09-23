package main.concurrency;

import java.util.function.IntConsumer;

public class LandRover {

    private final int n;
    private int currentNumber = 1;

    public LandRover(int n) {
        this.n = n;
    }

    public void land(Runnable land) throws InterruptedException {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                land.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public void rover(Runnable rover) throws InterruptedException {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                rover.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public void landRover(Runnable landRover) throws InterruptedException {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                landRover.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
        Thread.yield();
    }

    public void number(IntConsumer land) throws InterruptedException {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                land.accept(currentNumber);
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public int getN() {
        return n;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
