package org.anil;

import java.time.LocalTime;
import java.util.stream.IntStream;

public class HoppingVirtualThreads {

    public static void main(String[] args) throws Exception {

        IntStream.range(1, 8).forEach(i -> {
            Thread.startVirtualThread(() -> {
                log("START", i);
                sleep(2000);
                log("AFTER-SLEEP-1", i);
                sleep(2000);
                log("AFTER-SLEEP-2", i);
            });
        });


        Thread.sleep(6000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void log(String phase, int taskId) {
        Thread t = Thread.currentThread();
        System.out.printf(
                "%s | task=%02d | %-14s | vt=%-5s | %s%n",
                LocalTime.now(),
                taskId,
                phase,
                t.isVirtual(),
                t
        );
    }
}
