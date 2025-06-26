package javaconcurrency.basics;

public class VolatileDemo {

    private static volatile boolean running = true;

    private static StringBuffer buf = new StringBuffer();

    private static void log(String s) {buf.append(s + "\n"); }

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int counter = 0;
                while (running){
                    counter++;
                }
                log("Thread 1 finished. Counted up to " + counter);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log("Thread 2 finishing");
                running = false;
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(buf);
    }
}
