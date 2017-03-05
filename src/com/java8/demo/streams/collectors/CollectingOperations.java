package com.java8.demo.streams.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class CollectingOperations {

    public static void main(String[] args) {

        /**
         * Streams API supports collecting of elements into a collector,
         * Collector is a new interface, there are many implementations to it, however it is not a functional interface
         * Collectors is a utility class, which facilitate the collection
         */

        Stream<String> collectToListStream = getStringStream();

        //Collecting the stream into a list
        List<String> stringList =  collectToListStream.collect(Collectors.toList());
        System.out.println(stringList);

        //Collecting into a set
        Stream<String> collectToSetStream = getStringStream();
        Set<String> stringSet = collectToSetStream.collect(Collectors.toSet());
        System.out.println(stringSet);

        //Collecting into a Map
        Stream<String> collectToMapStream = Stream.of("abc","ab","ABCd","pqrsf","a");
        //Collector toMap() accepts two functions which returns the key and the value for the map
        //A function to produce a key and a function to produce value is provided
        Map<Integer,String> stringLengthValueMap = collectToMapStream.collect(Collectors
                .toMap(s -> s.length(), Function.identity()));
        System.out.println(stringLengthValueMap);

        /* Also you can collect to a given collection - but the collection should be mutable */
        LinkedList<String> stringLinkedList =getStringStream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("String linked list : " + stringLinkedList);


        /**When you are collecting from a primitive stream you have to use the function boxed() to convert the stream
         * into a wrapper stream to be collected by the List
         */

        List<Integer> integerList = IntStream.rangeClosed(1,100)
                .map(i -> i % 10)
                .boxed() //ToConvert to wrapper stream
                .collect(Collectors.toList());

        Map<Integer, Integer> integerSet = IntStream.rangeClosed(1, 100)
                .map(i -> i % 10)
                .filter(i -> i % 3 == 0 ? true : false)
                .map(i -> i * i)
                .distinct()
                .sorted()
                .limit(5)
                .boxed() //Function Identity can be used when a function returns same parameter it receives.
                .collect(Collectors.toMap( Function.identity()  , Function.identity() ));


        //Aggregate Functions

        /* Average */
        Stream<String> averageStream = getStringStream();
        Double averageLength = averageStream.collect(Collectors.averagingInt(String::length));
        System.out.printf("average length of the string %f \n",averageLength );

        /* Min */
        Stream<String> minStream = getStringStream();
        Optional<Integer> minLength = minStream.map(String::length).collect(Collectors.minBy(Integer::compare));
        System.out.printf("min length of the string %d \n",minLength.get());

        /* Max */
        Stream<String> maxStream = getStringStream();
        Optional<Integer> maxLength = maxStream.map(String::length).collect(Collectors.maxBy(Integer::compare));
        System.out.printf("Max length of the string %d \n",maxLength.get());

        // since the passing parameter is of type int we have to use summarizingInt() function
        // if is was double we should have used summarizingDouble() function
        Stream<String> summaryStream = getStringStream();
        IntSummaryStatistics summary = summaryStream.collect(Collectors.summarizingInt(String::length));
        System.out.printf("String length summary avarage : %f count : %d max : %d min : %d : \n",
                summary.getAverage(),summary.getCount(),summary.getMax(),
                summary.getMin());


        /* Joining */
        //Is used to add a delimiter suffix and prefix
        Stream<String> basicJoinStream = getStringStream();
        String someJoiningString = basicJoinStream
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining(" | ", " <", "> "));

        System.out.println("JST : " + someJoiningString);

        /* Counting */
        Long count = getStringStream().collect(Collectors.counting());
        System.out.println("Count of the stream : " + count);






    }

    private static Stream<String> getStringStream() {
        return Stream.of("abc","ab","ABC","pqrs","a","b","c","PQRS","ffffff","wwwwwwwww");
    }

}
