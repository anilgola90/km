package org.anil;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.TimeoutException;

public class StructuredConcurrency {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


              //  i want to run 3 tasks in parallel
              // if i want to get the fastest result
             //  i want to cancel the other two task

          try(var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()){


            var task1 =   scope.fork(() -> "server 1 ");
            var task2 =   scope.fork(() -> {
                 throw new RuntimeException("server 2");
            });
            var task3 =  scope.fork(() -> "server 3");

            scope.join(); // blocking call


            String result  = scope.result();




              System.out.println(result);









          }catch(Exception ex){
              ex.printStackTrace();
          }


    }
}
