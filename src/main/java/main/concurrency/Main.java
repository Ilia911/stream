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
            if (landRover.getN() < 1 || landRover.getN() > 50) {
                System.out.println("Number must be more then 0 and less then 51");
                return;
            }
            while (landRover.getCurrentNumber() <= landRover.getN()) {
                    landRover.land(land);
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
            if (landRover.getN() < 1 || landRover.getN() > 50) {
                System.out.println("Number must be more then 0 and less then 51");
                return;
            }
            while (landRover.getCurrentNumber() <= landRover.getN()) {
                landRover.rover(rover);
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
            if (landRover.getN() < 1 || landRover.getN() > 50) {
                System.out.println("Number must be more then 0 and less then 51");
                return;
            }
            while (landRover.getCurrentNumber() <= landRover.getN()) {
                landRover.landRover(landrover);
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
            if (landRover.getN() < 1 || landRover.getN() > 50) {
                System.out.println("Number must be more then 0 and less then 51");
                return;
            }
            while (landRover.getCurrentNumber() <= landRover.getN()) {
                landRover.number(number);
            }
        }
    }
}
