package org.anil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PlatformThreadThroughput {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(50);

        Instant start = Instant.now();

        IntStream.range(0, 10000).forEach(i ->
                executor.submit(() -> {
                    sleep(100); // simulates blocking I/O
                })
        );

        executor.shutdown();
        while (!executor.isTerminated()) {}

        System.out.println("Platform threads time = " +
                Duration.between(start, Instant.now()).toMillis() + " ms");
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}

