package org.anil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadThroughput {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        Instant start = Instant.now();

        IntStream.range(0, 10000).forEach(i ->
                executor.submit(() -> {
                    sleep(100); // SAME blocking call
                })
        );

        executor.shutdown();
        while (!executor.isTerminated()) {}

        System.out.println("Virtual threads time = " +
                Duration.between(start, Instant.now()).toMillis() + " ms");
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}

