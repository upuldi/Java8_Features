package com.java8.demo.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/28/17.
 */
public class StreamBasics_Creation {


    /**
     * Collections are for data storage
     * Streams are sequence of data which support
     *  internal iteration
     *  infinite data
     *  dynamic computation
     *  no data storage
     */



    public static void main(String[] args) {

        //Stream creation
        Stream<String> emptyStringStream = Stream.empty();
        Stream<String> streamWithSomeValues = Stream.of("Value","Another Value","Some Other Value");

        //Creating a stream of array
        String[] arrayOfStrings = {"A","B","C","D"};
        Stream<String> creatingAStreamWithAnArray = Stream.of(arrayOfStrings);

        //Stream from collection
        List<String> aListOfString = new ArrayList<>();
        Stream<String> aStreamFromList = aListOfString.stream();

        //Stream from infinite values
        Stream<Double> infiniteStream = Stream.generate(Math::random);

        //Also a function can be used to generate a stream
        Stream<Integer> streamGeneratedFromFunction = Stream.iterate(10, i -> i+1);

        //Streams have been supported in other APIs as well.
        try {
            Stream<String> linesFromAFileAsAStream = Files.lines(Paths.get("/some/file"));
        } catch (IOException e) {}

        //Primitive Streams are used to avoid the boxing cost
        //For ex following map reduce is expensive
        Stream<String> stringStream = Stream.of("A","AB","ABC","ABCD","ABCDEF");
        Optional<Integer> result = stringStream.map(String::length).reduce(Integer::sum);
        System.out.println(result.get());

        //There are three types of Primitive streams

        //Int streams
        IntStream intStream = IntStream.of(1,2,3,4,5);
        intStream.forEach(System.out::println);

        int[] intArray = {1,2,3,4,5};
        IntStream intStreamFromArray = IntStream.of(intArray);
        intStreamFromArray.forEach(System.out::println);

        //Likewise doublestreams and long stream are there
        DoubleStream doubleStream = DoubleStream.of(1.1,1.2,1.3,1.4);
        LongStream longStream = LongStream.of(111,112,113,114);

        //So the above can be written like this
        Stream<String> primitiveStreamsDemo = Stream.of("A","AB","ABC","ABCD","ABCDEF");
        int primitiveStreamsDemoResult = primitiveStreamsDemo.mapToInt(String::length).sum();
        System.out.println(primitiveStreamsDemoResult);

        /* You can transform an Object stream into a primitive stream and vise versa using mapToInt(), maptToLong() and mapToDouble() */
        Stream.of("A1","A2","A3","A4").map(s -> s.substring(1)).mapToInt(Integer::parseInt).forEach(System.out::println);


        //Here mapToInt() converts it to an int stream
        // IntStreams has sum() function within itself, so no need of doing reduce()


    }
}
