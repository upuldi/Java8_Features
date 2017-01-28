package com.java8.demo.functions.summary;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

/**
 * Created by udoluweera on 1/28/17.
 */
public class ConsumersSummary {

    public static void main(String[] args) {

        //Takes one input and consumes it,
        // accept() method is used to perform the operation
        Consumer<String> stringConsumer = (s) -> System.out.println("hello " + s + ".....");
        stringConsumer.accept("consumer");

        Consumer<Integer> multiplyItBy10 = (i) -> System.out.println(i * 10);
        multiplyItBy10.accept(100);

        Consumer<String> addDecoration = (s) -> System.out.format("**** %s ****\n",s);
        Consumer<String> complex = stringConsumer.andThen(addDecoration);
        complex.accept("ADVANCED");

        BiConsumer<String,Integer> byConsumer = (s,i) -> System.out.format(" %s and %d \n",s,i);
        byConsumer.accept("A",100);

        //For Primitives
        IntConsumer intConsumer = (i) -> System.out.println(i);
        intConsumer.accept(100);

        DoubleConsumer doubleConsumer = (i) -> System.out.println(i);
        doubleConsumer.accept(100.001);

    }
}
