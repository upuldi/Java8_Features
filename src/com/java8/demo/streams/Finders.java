package com.java8.demo.streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class Finders {

    public static void main(String[] args) {

        //Finders works with filters
        //AnyMatch Doesn't Work with filter

        //Find First Demo
        //Fetch the first matching filter
        //FindFist waits till the whole stream is processed, where as find any is not
        Stream<String> findFirstDemoStream = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        Optional<String> firstChapWord =  findFirstDemoStream
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .findFirst(); //Returns an optional
        System.out.println("First Cap Word : " + firstChapWord.get());


        //Find Any Demo
        //Work same as find first but more efficient when running parallel

        Stream<String> findAnyDemoStream = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        Optional<String> anyChapWord =  findAnyDemoStream
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .findAny();
        System.out.println("Any Cap Word : " + anyChapWord.get());

        //AnyMatch demo
        //anyMatch() is used to check whether is there a single element in the stream which full filling the given predicate
        // It returns a boolean value

        Stream<String> anyMatchStreamDemo = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        boolean anyMatchResult = anyMatchStreamDemo
                .anyMatch(s -> s.equals("ABC"));

        System.out.println("anyMatch : " + anyMatchResult);

        //None match demo
        //same as anyMatch() Doesnt work with filter
        //Returns a boolean value

        Stream<String> noneMatchStreamDemo = Stream.of("kLm","xyz","ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        boolean noneMatchResult = noneMatchStreamDemo
                .noneMatch(s -> s.equalsIgnoreCase("123"));

        System.out.println("noneMatch : " + noneMatchResult);

    }
}
