package main.concurrency;

import java.util.function.IntConsumer;

public class LandRover implements Runnable {

    private final int n;
    private volatile int currentNumber = 1;

    private final Runnable land = () -> System.out.print("\"land\",");
    private final Runnable rover = () -> System.out.print("\"rover\",");
    private final Runnable landRover = () -> System.out.print("\"landRover\",");
    private final IntConsumer number = (number) -> System.out.print(number + ",");

    public LandRover(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        while (currentNumber <= n) {
            if ("Thread-A".equals(Thread.currentThread().getName())) {
                land(land);
                Thread.yield();
                continue;
            }
            if ("Thread-B".equals(Thread.currentThread().getName())) {
                rover(rover);
                Thread.yield();
                continue;
            }
            if ("Thread-C".equals(Thread.currentThread().getName())) {
                landRover(landRover);
                Thread.yield();
                continue;
            }
            if ("Thread-D".equals(Thread.currentThread().getName())) {
                number(number);
                Thread.yield();
            }
        }
    }

    public synchronized void land(Runnable land) {
        if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 != 0) {
            land.run();
            currentNumber++;
        }
    }

    public synchronized void rover(Runnable rover) {
        if (currentNumber <= n && currentNumber % 5 == 0 && currentNumber % 3 != 0) {
            rover.run();
            currentNumber++;
        }
    }

    public synchronized void landRover(Runnable landRover) {
        if (currentNumber <= n && currentNumber % 3 == 0 && currentNumber % 5 == 0) {
            landRover.run();
            currentNumber++;
        }
    }

    public synchronized void number(IntConsumer land) {
        if (currentNumber <= n && currentNumber % 3 != 0 && currentNumber % 5 != 0) {
            land.accept(currentNumber);
            currentNumber++;
        }
    }
}
