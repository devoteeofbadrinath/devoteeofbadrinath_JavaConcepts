package javaconcurrency.streams;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamsDemo2 {

    private static class MutableInteger {
        private int value = 0;

        public synchronized void increment() {value++;}

        public int getValue() {return value;}
    }
    public static void main(String[] args) {
        MutableInteger mutableInteger = new MutableInteger();
        IntStream.range(0, 1000000)
                .parallel()
                .unordered()
                .forEach(i -> mutableInteger.increment());
                //.forEach(i -> System.out.println(i));
        System.out.println(mutableInteger.getValue());
    }
}
