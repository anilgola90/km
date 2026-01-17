package org.anil;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.TimeoutException;

public class WeatherExcercise {


    static void main(String[] args) throws InterruptedException {

        // fetch result from fastest server
        // if any one of them fails, no issue
        // if all fails then print the exceptions

        try(var scope = new StructuredTaskScope<>()){

            scope.fork(() -> getWeatherFromA("london"));
            scope.fork(() -> getWeatherFromB("london"));
            scope.fork(() -> getWeatherFromC("london"));



        scope.join();



        }
        catch (Exception e){
            System.out.println("Error");
        }





    }

    static class CustomTaskScope<String> extends StructuredTaskScope<String>{
        @Override
        protected void handleComplete(Subtask<? extends String> subtask) {
            super.handleComplete(subtask);
        }

       List<String> getResults(){
            return null;
        };


    }


    public static String getWeatherFromA(String city) {
       sleep(6000);
       return "Server A sunny and light rain";
      //  return "Server B sunny";
    }

    public static String getWeatherFromB(String city) {

        sleep(6000);
        return "Server B sunny and light rain";
    }

    public static String getWeatherFromC(String city) {
        sleep(6000);
        return "Server C sunny and light rain";
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
