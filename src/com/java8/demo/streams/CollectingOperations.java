package com.java8.demo.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
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

        Stream<String> collectToListStream = Stream.of("abc","ab","ABC","pqrs","a","b","c","PQRS");

        //Collecting the stream into a list
        List<String> stringList =  collectToListStream.collect(Collectors.toList());
        System.out.println(stringList);

        //Collecting into a set
        Stream<String> collectToSetStream = Stream.of("abc","ab","ABC","pqrs","a","b","c","PQRS");
        Set<String> stringSet = collectToSetStream.collect(Collectors.toSet());
        System.out.println(stringSet);

        //Collecting into a Map
        Stream<String> collectToMapStream = Stream.of("abc","ab","ABCd","pqrsf","a");
        //Collector toMap() accepts two functions which returns the key and the value for the map
        //A function to produce a key and a function to produce value is provided
        Map<Integer,String> stringLengthValueMap = collectToMapStream.collect(Collectors
                .toMap(s -> s.length(), s -> s));
        System.out.println(stringLengthValueMap);

    }

}
