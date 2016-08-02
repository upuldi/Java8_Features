package com.java8.demo.lambda.interfaceMethods;

/**
 * Created by udoluweera on 8/1/16.
 */
public class DefaultMethodsDemo {

    @FunctionalInterface
    interface DefaultMethodDemoInterface {

        public void usualFunctionalMethod(int x);

        /**
         * This is a default method, Functional Interfaces can have a default methods
         */
        public default boolean someDefaultMethod(String x, String y) {
            System.out.println("A default Method");
            return true;
        }
    }


    public static void main(String[] args) {

    }
}
