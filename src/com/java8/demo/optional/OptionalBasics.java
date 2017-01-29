package com.java8.demo.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class OptionalBasics {

    public static void main(String[] args) {


        //A typical use of optional in java
        Stream<String> stringStream = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        Optional<Integer> sumOfAllStrings = stringStream
                .map(String::length)
                .reduce(Integer::sum);

        System.out.println(sumOfAllStrings.get());



    }
}
