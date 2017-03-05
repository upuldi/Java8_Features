package com.java8.demo.functions.consumer;

import java.util.function.*;

/**
 * Created by udoluweera on 8/8/16.
 */
public class BiConsumerDemo {


    //Accepts two arguments as inputs
    BiConsumer<SomeClass,Integer> twoInputConsumer = (o,i) -> System.out.println("Do something with two inputs....");
    BiConsumer<SomeClass,Integer> anotherConsumer = null;

    private void someMethod() {
        BiConsumer<SomeClass, Integer> bothConsumers = twoInputConsumer.andThen(anotherConsumer);
    }

    public static void main(String[] args) {
    }

    class SomeClass {}
}
