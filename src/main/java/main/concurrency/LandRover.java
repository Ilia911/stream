package main.concurrency;

import java.util.function.IntConsumer;

public class LandRover {

    private final int n;
    private int currentNumber = 1;

    public LandRover(int n) {
        this.n = n;
    }

    public void land(Runnable land) {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                land.run();
                currentNumber++;
            }
        }
        Thread.yield();
    }

    public void rover(Runnable rover) {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                rover.run();
                currentNumber++;
            }
        }
        Thread.yield();
    }

    public void landRover(Runnable landRover) {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                landRover.run();
                currentNumber++;
            }
        }
        Thread.yield();
    }

    public void number(IntConsumer land) {

        synchronized (this) {
            if (currentNumber <= n && currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                land.accept(currentNumber);
                currentNumber++;
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
