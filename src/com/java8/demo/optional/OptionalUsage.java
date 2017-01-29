package com.java8.demo.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class OptionalUsage {

    public static void main(String[] args) {


        //A typical use of optional in java
        Stream<String> stringStream = Stream.of("kLm", "xyz", "ABC", "ab", "ABC", "PQRS", "a", "b", "c", "PQRS", "abc");

        Optional<Integer> sumOfAllStrings = stringStream
                .map(String::length)
                .reduce(Integer::sum);

        System.out.println(sumOfAllStrings.get());

        //If optional get was executed on a empty option it will throw a NoSuchElementExeception

        Optional<String> emptyOption = Stream.of("XYZ","ABC")
                .filter(s -> s.length() > 4 )
                .reduce( (a,b) -> a + "," + b);
        try {
            System.out.println(emptyOption.get());
        } catch (NoSuchElementException e) {
            System.out.println(" Exception : " + e.getMessage());
        }

        //So the solution is to use isPeresent() method

        //isPresent() demo

        Optional<String> anotherOption = Stream.of("XYZ","ABC")
                .filter(s -> s.length() > 4 )
                .reduce( (a,b) -> a + "," + b);

        if (anotherOption.isPresent()){
            System.out.println(" isPresent : " + anotherOption.get());
        } else {
            System.out.println("NO Exception");
        }





    }
}
