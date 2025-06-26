package javaconcurrency.basics;

public class DaemonDemo {
    public static void main(String[] args) {
        new WorkerThread().start();
        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread ending");
    }
}

class WorkerThread extends Thread {

    public WorkerThread() {
        setDaemon(true);
    }
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Hello from Worker " + count++);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
