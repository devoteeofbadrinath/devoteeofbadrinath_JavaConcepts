package javaconcurrency.lostupdate;

public class LostUpdateDemo {

    private static class SynchronizedThread implements Runnable {
        private int value = 0;

        @Override
        public void run() {

            for (int i = 1; i < 5000; i++) {
                increment();
                Thread.yield();
            }

        }

        public void increment() {
            int i = value;
            value = i + 1;
        }

        public int getValue() { return value;}
    }

    public static void main(String[] args) {
        SynchronizedThread job = new SynchronizedThread();
        SynchronizedThread job1 = new SynchronizedThread();
        SynchronizedThread job2 = new SynchronizedThread();
        Thread t1 = new Thread(job, "t1");
        Thread t2 = new Thread(job, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(job.getValue());
        System.out.println(job1.getValue());
        System.out.println(job2.getValue());
    }
}
