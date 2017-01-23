package com.java8.demo.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 8/8/16.
 */
public class StreamCreation {


    private void createAnEmptyStream(){
        Stream<SomeType> emptyStream = Stream.empty();
        System.out.println("Empty Stream : " + emptyStream.count());
    }

    private void createStreamUsingValues() {
        Stream<String> streamWithValues = Stream.of("SomeValue","AnotherValue");
        System.out.println("Stream with values : " + streamWithValues.count());

        //Also you can provide an array
        String[] arrayOfObj = {"String","AnotherString"};
        Stream<String> anotherStreamFromValues = Stream.of(arrayOfObj);
    }

    private void createStreamsFromCollection() {
        //Collection interface has a method called stream which create a stream out of a collection.
        List<String> aListOfStrings = Arrays.asList("StringOne ","StringTwo ");

        //stream() method is available in the collection interface
        Stream<String> aSreamFromList = aListOfStrings.stream();

        aListOfStrings.forEach(System.out::print);
        //Consumer witout the method reference
        aListOfStrings.forEach((s)-> System.out.println(s));
    }


    public void streamWithInfiniteValues() {
        //Streams can be generated like this.
        //generate uses a supplier
        Stream<Double> randomStream = Stream.generate(Math::random);

        //Generate method uses a supplier for generating values.
        //But for seeder (to provide the values by us ) we can use iterate method
        Stream<Integer> wholeNumberStream = Stream.iterate(1,(i)->i+1);
        wholeNumberStream.forEach(System.out::println);
    }

    public void streamsInOtherAPIs() {

        //Not only the collection class, the new file class also supports streams

        try {

            Stream<String> linesFromAFileAsAStream = Files.lines(Paths.get("/some/file"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        StreamCreation streamCreation = new StreamCreation();
        streamCreation.createAnEmptyStream();
        streamCreation.createStreamUsingValues();
        streamCreation.createStreamsFromCollection();
        streamCreation.streamWithInfiniteValues();

    }

    class SomeType{

    }

}
