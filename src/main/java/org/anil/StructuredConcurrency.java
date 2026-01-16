package org.anil;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrency {
    public static void main(String[] args) throws InterruptedException {

        // seller data
        // seller score
        // combine

//
//         1000 application
//             --> pancardauthority
//             --> aadhar authority
//             --> i need to calculate score once above two finish

        Thread[] threads = new Thread[10];
      for(int i=0; i<10; i++){
          int iteration = i;

          threads[i] = Thread.startVirtualThread(()->{

              try(var scope = new StructuredTaskScope.ShutdownOnFailure())
              {


                  var task1 = scope.fork(() -> {
                       if(iteration == 5){
                           throw new RuntimeException("exception in 500");
                       }
                      return "pancardauthority";
                  });

                  var task2 = scope.fork(() -> {
                      return "adhar data";
                  });

                  scope.join();
                   scope.throwIfFailed();

                  var result1 = task1.get();
                  var result2 = task2.get();

                  System.out.println(result1 + " " + result2);

              }
              catch (Exception ex){
                  System.out.println(ex);
              }

          });




      }


for(Thread thread : threads){
    thread.join();
}


    }
}
