package main.concurrency;

public class Main {

    public static void main(String[] args) {
        go();
    }

    private static void go() {
        Runnable landRover = new LandRover(15);

        new Thread(landRover, "Thread-A").start();
        new Thread(landRover, "Thread-B").start();
        new Thread(landRover, "Thread-C").start();
        new Thread(landRover, "Thread-D").start();
    }
}
