package javaconcurrency.writeread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    private static int TIMEOUT = 500;

    public Producer(BlockingQueue<String> blockingQueue) {this.blockingQueue = blockingQueue;}
    @Override
    public void run() {
        try{
            blockingQueue.put("A");
            Thread.sleep(TIMEOUT);
            blockingQueue.put("B");
            Thread.sleep(TIMEOUT);
            blockingQueue.put("C");
            Thread.sleep(TIMEOUT);
            blockingQueue.put("D");
            Thread.sleep(TIMEOUT);
            blockingQueue.put("E");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
