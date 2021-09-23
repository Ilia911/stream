package main.concurrency;

import java.util.function.IntConsumer;

public class Main {

    public static void main(String[] args) {
        go();
    }

    private static void go() {

        LandRover landRover = new LandRover(15);

        new ThreadA(landRover).start();
        new ThreadB(landRover).start();
        new ThreadC(landRover).start();
        new ThreadD(landRover).start();
    }

    static class ThreadA extends Thread {

        private final LandRover landRover;
        private final Runnable land = () -> System.out.print("\"land\",");

        public ThreadA(LandRover landRover) {
            super();
            this.landRover = landRover;
        }

        @Override
        public void run() {
            try {
                landRover.land(land);
            } catch (InterruptedException e) {
                System.out.println("The thread was interrupted");
            }
        }
    }

    static class ThreadB extends Thread {

        private final LandRover landRover;
        private final Runnable rover = () -> System.out.print("\"rover\",");

        public ThreadB(LandRover landRover) {
            super();
            this.landRover = landRover;
        }

        @Override
        public void run() {
            try {
                landRover.rover(rover);
            } catch (InterruptedException e) {
                System.out.println("The thread was interrupted");
            }
        }
    }

    static class ThreadC extends Thread {

        private final LandRover landRover;
        private final Runnable landrover = () -> System.out.print("\"landRover\",");

        public ThreadC(LandRover landRover) {
            super();
            this.landRover = landRover;
        }

        @Override
        public void run() {
            try {
                landRover.landRover(landrover);
            } catch (InterruptedException e) {
                System.out.println("The thread was interrupted");
            }
        }
    }

    static class ThreadD extends Thread {

        private final LandRover landRover;
        private final IntConsumer number = (number) -> System.out.print(number + ",");

        public ThreadD(LandRover landRover) {
            super();
            this.landRover = landRover;
        }

        @Override
        public void run() {
            try {
                landRover.number(number);
            } catch (InterruptedException e) {
                System.out.println("The thread was interrupted");
            }
        }
    }
}
