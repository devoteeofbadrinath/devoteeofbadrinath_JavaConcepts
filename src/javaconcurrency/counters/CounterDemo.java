package javaconcurrency.counters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterDemo {

    private static final int ITERATIONS = 1000000;

    //private static int counter = 0;

    private static AtomicInteger counter = new AtomicInteger(0);

    private static Object lock = new Object();

    private static class ThreadExample implements Runnable {
        private String name;

        public ThreadExample(String name) { this.name = name; }

        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                //synchronized (lock) {
                //    counter++;
                //}
                counter.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new ThreadExample("thread" + i)));
        }
        System.out.println("Starting threads");
        for (int i = 0; i < 100; i++) {
            threads.get(i).start();
        }
        try {
            for (int i = 0; i < 100; i++) {
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter=" + counter.get());
    }
}
