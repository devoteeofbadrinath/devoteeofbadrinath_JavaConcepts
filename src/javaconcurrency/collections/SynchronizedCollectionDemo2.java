package javaconcurrency.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedCollectionDemo2 {

    private static final int ITERATIONS = 1000;

//    private static List<Integer> integerList = new ArrayList<>();
    private static List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());
//    private static List<Integer> integerList = new CopyOnWriteArrayList<>();

    private static Object monitor = new Object();

    private static class IntegerGenerator implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (monitor) {
                    integerList.add(new Random().nextInt(10));
                    print(integerList);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            threads.add(new Thread(new IntegerGenerator()));
        }
        System.out.println("Starting threads");
        for (int i = 0; i < ITERATIONS; i++) {
            threads.get(i).start();
        }
        System.out.println("Waiting for threads");
        try{
            for (int i = 0; i < ITERATIONS; i++) {
                threads.get(i).join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(integerList.size());
    }

    private static void print(Collection<?> c){
        StringBuilder builder = new StringBuilder();
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()){
            builder.append(iterator.next()).append(" ");
        }
    }
}
