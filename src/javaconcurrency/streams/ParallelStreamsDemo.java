package javaconcurrency.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //integerList.stream().forEach(value -> System.out.println(Thread.currentThread().getName() + ": " + value));
        integerList.stream().parallel().
                forEach(value -> System.out.println(Thread.currentThread().getName() + ": " + value));
    }
}
