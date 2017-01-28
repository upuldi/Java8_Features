package com.java8.demo.streams;

import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/28/17.
 */
public class LazyAndEagerStreams {

    public static void main(String[] args) {

        /**
         * If a method get executed right away it is called eager method
         * if it is not the case it is called lazy method
         */
        /*For ex filter is a lazy method, the following will not get executed */
        Stream<String> lazyFilterDemo = Stream.of("A","AB","ABC","ABCD");
        lazyFilterDemo.filter((s) -> {
            System.out.println("Inside the lazy filter demo..." + s);
            return s.length() > 1 ? true : false;
        });

        //It will only get executed with terminal operators like count()
        Stream<String> lazyFilterDemoWithCount = Stream.of("A","AB","ABC","ABCD");
        lazyFilterDemoWithCount.filter((s) -> {
            System.out.println("Inside the lazy filter demo with count..." + s);
            return s.length() > 2 ? true : false;
        }).count();
        //Even though the length is 2 filter execute on everything

        System.out.println("\n Eager method demo \n ");

        //Map is a eager method
        Stream<String> mapEagerDemo = Stream.of("A","AB","ABC","ABCD");
        mapEagerDemo.filter((s) -> {
            System.out.println("Inside lazy filter method..." + s);
            return s.length() > 2 ? true : false;
        }).map(s -> {
            System.out.println("Inside eager map method..." + s);
            return s.toUpperCase();
        }).count();
        // See map is only executed on the relevant elements on the stream







    }
}
