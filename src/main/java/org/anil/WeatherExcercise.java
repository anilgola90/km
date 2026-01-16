package org.anil;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.StructuredTaskScope;

public class WeatherExcercise {


    static void main(String[] args) {

        // fetch result from fastest server
        // if any one of them fails, no issue
        // if all fails then print the exceptions




    }


    public static String getWeatherFromA(String city) {
       throw new RuntimeException("Server A is down");
      //  return "Server B sunny";
    }

    public static String getWeatherFromB(String city) {
        return "Server B sunny and light rain";
    }

    public static String getWeatherFromC(String city) {
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
