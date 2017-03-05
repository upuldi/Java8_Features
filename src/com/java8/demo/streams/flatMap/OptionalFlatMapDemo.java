package com.java8.demo.streams.flatMap;

import java.util.Optional;

/**
 * Created by L078878 on 20/02/2017.
 */
public class OptionalFlatMapDemo {

    static class Parent {

        private Child child;

        public Child getChild() {
            return child;
        }

        public void setChild(Child child) {
            this.child = child;
        }
    }

    static class Child {

        GrandChild grandChild;

        public GrandChild getGrandChild() {
            return grandChild;
        }

        public void setGrandChild(GrandChild grandChild) {
            this.grandChild = grandChild;
        }
    }

    static class GrandChild {

        private String someField = "Some Value";

        public String getSomeField() {
            return someField;
        }

        public void setSomeField(String someField) {
            this.someField = someField;
        }
    }


    /**
     * Optional Flatmaps are used to avoid null checking of child objects
     *
     * @param args
     */

    public static void main(String[] args) {

        Optional.of(new Parent())
                .flatMap(p ->  Optional.ofNullable( p.getChild()))
                .flatMap(c -> Optional.ofNullable(c.getGrandChild()))
                .flatMap(g -> Optional.ofNullable(g.getSomeField()))
        .ifPresent(System.out::println);


    }
}
