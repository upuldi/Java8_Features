package com.java8.demo.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class Filtering {

    public static void main(String[] args) {

        /**
         * Filters takes predicate as an input
         */
        Stream<String> stringStream = Stream.of("abc","ab","ABC","pqrs","a","b","c","PQRS");
        stringStream
                .filter(s -> s.length()>1)
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .forEach(System.out::println);







    }
}
