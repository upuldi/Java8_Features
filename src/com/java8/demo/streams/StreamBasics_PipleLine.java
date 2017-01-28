package com.java8.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/28/17.
 */
public class StreamBasics_PipleLine {

    public static void main(String[] args) {

        /**
         * Stream uses pipeline pattern, there are many intermediaries but one terminator operation
         * for ex : foreach is a terminator operator
         */

        long startStream = System.nanoTime();

        List<String> stringList = Arrays.asList("ab","pqrs","XYZ","something","ss","something","XYZ","something");
        stringList.stream().
                filter((s) -> s.length() > 2).//Filter function
                map( (s) ->   String.format("<< %s >>",s)). //Collecting function
                distinct().
                limit(4).
                forEach(System.out::println);//Terminal operation

        long endStream = System.nanoTime();
        System.out.println("Time taken : " + ((endStream - startStream)/1000000));

        long startParallelStream = System.nanoTime();

        //Parallel streams works same as streams
        stringList.parallelStream().filter((s) -> s.length() > 2).//Filter function
                map( (s) ->   String.format("<< %s >>",s)). //Collecting function
                distinct().
                limit(4).
                forEach(System.out::println);//Terminator operation

        long endParallelStream = System.nanoTime();
        System.out.println("Time taken Parallel : " + ((endParallelStream - startParallelStream)/100000));

        //Map Reduce
        Stream<String> stringStream = Stream.of("A","AB","ABC","ABCD","ABCDEF");
        Optional<Integer> result = stringStream.map(String::length).reduce(Integer::sum);
        System.out.println(result.get());

    }
}
