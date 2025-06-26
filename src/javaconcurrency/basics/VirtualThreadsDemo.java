package  javaconcurrency.basics;

public class VirtualThreadsDemo {

    public static void main(String[] args) {
            Runnable runnable = new Runnable(){

            @Override
            public void run(){
                System.out.println("Virtual Threads Demo");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("Starting virutal thread");

        Thread virtualThread = Thread.startVirtualThread(runnable);
        System.out.println(virtualThread.isDaemon());

        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End of main");
    }
}
