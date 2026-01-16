package org.anil;

public class InventoryExcercise {

    static void main() {
        // fetch getInventory, getQuanity, getInvoice in paraller
        // if any of them fails, throw exceptions
        // if all pass print combine result


        // if any task takes more than 1 second, fail the execution
        // and print the error message



    }




    public static String getInventory(String city) {
        //throw new RuntimeException("Server A is down");
          return "getInventory";
    }

    public static String getQuanity(String city) {
        return "get quanity";
    }

    public static String getInvoice(String city) {
        return "Get Invoice";
    }
}
