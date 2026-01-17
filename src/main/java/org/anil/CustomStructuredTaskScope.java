package org.anil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.StructuredTaskScope;

import static java.util.concurrent.Future.State.CANCELLED;

public class CustomStructuredTaskScope {


    static void main() {


        try(var scope = new CustomeTaskScope<String>()){

            StructuredTaskScope.Subtask<String> fork = scope.fork(() -> "docment1 processing");
            scope.fork(() -> "docment2 processing");
            scope.fork(() -> "docment3 processing");


            scope.join();
            var results = scope.getResults();
            var exceptions = scope.getExceptions();;

            System.out.println(results);



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    static class CustomeTaskScope<String> extends StructuredTaskScope<String>{

        List<String> results = new CopyOnWriteArrayList<>();

        List<Throwable> exceptions = new CopyOnWriteArrayList<>();
        @Override
        protected void handleComplete(Subtask<? extends String> subtask) {

            switch (subtask.state()){
                case SUCCESS -> results.add(subtask.get());

                case FAILED -> exceptions.add(subtask.exception());



            }


        }

        List<String>  getResults(){
            return results;
        }

        List<Throwable>   getExceptions(){
            return exceptions;
        }
    }




}
