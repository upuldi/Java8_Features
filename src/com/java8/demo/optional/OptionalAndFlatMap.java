package com.java8.demo.optional;

import java.util.Optional;

/**
 * Created by L078878 on 17/02/2017.
 */
public class OptionalAndFlatMap {

    static class Outer {
        Nested nested;
    }

    static class Nested {
        Inner inner;
    }

    static class Inner {
        String innerField;
    }

    public static void main(String[] args) {

        Outer outer = new Outer();
        Nested nested = new Nested();
        Inner inner = new Inner();
        inner.innerField = " This is a not null inner field...";
        nested.inner = inner;
        outer.nested = nested;


        /**
         * Null checks of inheritance hierarchies can be done with flatmaps and optionals
         */

        Optional.of(outer)
                .flatMap( o -> Optional.ofNullable(o.nested)  )
                .flatMap( n -> Optional.ofNullable(n.inner))
                .flatMap( i -> Optional.of(i.innerField))
                .ifPresent(System.out::println);




    }

}
