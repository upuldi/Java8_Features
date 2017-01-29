package com.java8.demo.streams;

import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class DistinctLimitAndSkip {

    public static void main(String[] args) {


        //Distinct is used to distinct the elements

        Stream<String> distinctDemo = Stream.of("ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");
        distinctDemo
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n Limit demo \n");

        //Limit is used to limit the result set
        //If the limit is more than the original list, whole list will be returned
        Stream<String> limitDemo = Stream.of("ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        limitDemo
                .limit(3)
                .forEach(System.out::println);


        System.out.println("\n Skip demo \n");

        //Skip is used to skip a certain no of elements
        //If the skipping no is greater than the stream size it will produce an empty list
        Stream<String> skipDemo = Stream.of("ABC","ab","ABC","PQRS","a","b","c","PQRS","abc");

        skipDemo
                .skip(5) //First 5 elements will be skipped
                .forEach(System.out::println);
    }
}
