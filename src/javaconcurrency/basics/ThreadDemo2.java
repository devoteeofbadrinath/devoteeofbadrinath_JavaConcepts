package javaconcurrency.basics;

public class ThreadDemo2 {

    private static StringBuffer result = new StringBuffer();

    private static void log(String s) {result.append(s + "\n"); }

    private static class ThreadExample implements Runnable {
        private String name;

        public ThreadExample(String name) {this.name = name; }

        @Override
        public void run() {
            for (int i = 0; i < 10; i ++) {
                log(name + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExample("t1"));
        Thread t2 = new Thread(new ThreadExample("t2"));
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Starting threads");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End of main");
        System.out.println(result);
    }
}
