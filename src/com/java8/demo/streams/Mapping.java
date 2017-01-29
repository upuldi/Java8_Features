package com.java8.demo.streams;

import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class Mapping {

    public static void main(String[] args) {

        /**
         * Map consumes a function, perform a state conversion on the elements
         */

        Stream<String> stringStream = Stream.of("abc","ab","ABC","pqrs","a","b","c","PQRS");
        stringStream
                .map(String::length)
                .forEach(System.out::println);


    }
}
