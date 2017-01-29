package com.java8.demo.streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class Reducing {

    public static void main(String[] args) {

        /**
         * Reducing is a way of aggregating into a single result.
         * There are three variants of this operation.
         */

        //Reduce operator takes a binary parameter, and returns an Optional
        //This uses accumulative function as the binary operator

        Stream<String> reducingStreamDemo = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        Optional<Integer> reduceResponse = reducingStreamDemo
                .map(String::length)
                .reduce( (a,b) -> a+b);

        System.out.println("Reduce Response : " + reduceResponse.get());


        Stream<String> anotherReduceDemoStream = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        Optional<String> comSeparatedValues = anotherReduceDemoStream
                .reduce( (a,b) -> a + "," + b);

        System.out.println("Reduce Response ComSep Vals : " + comSeparatedValues.get());

        //There is an overloaded reduce function which takes an initial value to the reduce function.
        //Since we provides an initial value, return type is of that value

        Stream<String> overLoadedRedFunDemoStream = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        String withInitialValue = overLoadedRedFunDemoStream
                .reduce("XXXX --- YYYY ", (a, b) -> a + "," + b);

        System.out.println("Reduce Response ComSep Vals with overload : " + withInitialValue);



    }
}
