package javaconcurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private static Thread t1, t2, t3;

    private static StringBuilder stringBuilder = new StringBuilder();

    public static long ITERATIONS = 10000;

    private static StringBuilder result = new StringBuilder();

    static void log(String s)  {result.append(s + "\n"); }

    private static class WritingThread implements Runnable {

        private String name;
        private Lock lock;

        public WritingThread(String name, Lock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                lock.lock();
                stringBuilder.append(name);
                Thread.yield();
                stringBuilder.append(name);
                Thread.yield();
                stringBuilder.append(" ");
                lock.unlock();
            }
        }
    }

    private static class ReadingThread implements Runnable {
        private Lock lock;

        public ReadingThread(Lock lock) { this.lock = lock; }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                String s = stringBuilder.toString();
                log(s.substring(Math.max(s.length() - 30, 0)).trim());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        t1 = new Thread(new WritingThread("A", lock));
        t2 = new Thread(new WritingThread("B", lock));
        t3 = new Thread(new ReadingThread(new ReentrantLock()));
        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
