package org.anil;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;

import static java.util.concurrent.Future.State.CANCELLED;

public class VirtualThreadsCreation {
    public static void main(String[] args) throws InterruptedException {



        var v1 = Thread.startVirtualThread(() -> {

            System.out.println("hello to virtual thread  :: " + Thread.currentThread().getName());
        });

        System.out.println(v1);



       var p1 =  Thread.ofPlatform().start(() -> {
            System.out.println("hello to platform thread" + Thread.currentThread().getName());
        });

        System.out.println(p1);



        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        service.submit(() -> {
            System.out.println("hello to virtual thread  :: " + Thread.currentThread().getName());
        });










    }

}