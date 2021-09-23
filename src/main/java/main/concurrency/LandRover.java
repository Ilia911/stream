package main.concurrency;

import java.util.function.IntConsumer;

public class LandRover {

    private final int n;
    private int currentNumber = 1;

    public LandRover(int n) {
        if (n < 1 || n > 50) {
            System.out.println("Number must be more then 0 and less then 51");
            System.exit(-1);
        }
        this.n = n;
    }

    public synchronized void land(Runnable land) throws InterruptedException {

        while(currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                land.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void rover(Runnable rover) throws InterruptedException {

         while (currentNumber <= n) {
            if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                rover.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void landRover(Runnable landRover) throws InterruptedException {

        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                landRover.run();
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void number(IntConsumer land) throws InterruptedException {

        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                land.accept(currentNumber);
                currentNumber++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }
}
