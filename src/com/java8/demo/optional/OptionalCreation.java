package com.java8.demo.optional;

import java.util.Optional;

/**
 * Created by udoluweera on 1/29/17.
 */
public class OptionalCreation {

    public static void main(String[] args) {

        //Options can be created as same as streams
        Optional<String> optionalValue = Optional.of("SomeStringValue");
        System.out.println(optionalValue.get());

        //If you try to access an optional defined as above and if it was null, it will produce a null pointer exception
        try{
            String nullString = null;
            Optional<String> optionalString = Optional.of(nullString);
            System.out.println(optionalString.get());

        } catch(Exception e) {
            System.out.println("exception occurred");
            System.out.println(e);
        }

        //However to avoid that, we can create optional types as bellow
        //It will create an empty optional type
        //There wont be null pointer exception, however it will be no such method exception
        String anotherNullString = null;
        Optional<String> nullableOptional = Optional.ofNullable(anotherNullString);
        System.out.println(nullableOptional);

        //ifPresent()
        //IfPresent() accepts a consumer
        Optional<String> ifPresentOptional = Optional.ofNullable(anotherNullString);

        //Use of IfPresent
        ifPresentOptional.ifPresent(System.out::println);

        //orElse()
        //Providing default values if it is a null value
        Optional<String> orElseOptional = Optional.ofNullable(anotherNullString);
        String value = orElseOptional.orElse("This is my default value");
        System.out.println(" Or Else Demo : " + value);

        //orElseThrow()
        //Can be used to throw an exception if null value is found

        Optional<String> orElseThrowExceptionOptional = Optional.ofNullable(anotherNullString);
        try{

            orElseThrowExceptionOptional.orElseThrow(Exception::new);

        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }

        //using filters
        //filter can be used to check a condition of the optional type
        //It accepts a predicate
        Optional<String> filteringOptional = Optional.of("abcd");
        filteringOptional.filter( s -> s.length() > 3 ? true : false )
                .ifPresent(System.out::println);

        //Using Maps
        //Maps can be used to manipulate data on optional types, using a function
        Optional<String> mapDemoOp = Optional.ofNullable("abcd");
        mapDemoOp.map(String::toUpperCase)
                .ifPresent(System.out::println);








    }
}
