package com.java8.demo.lambda.interfaceMethods;

/**
 * Created by udoluweera on 8/1/16.
 */
public class StaticMethodsDemo {

    @FunctionalInterface
    interface DefaultMethodDemoInterface {

        public void usualFunctionalMethod(int x);

        /**
         * This is a default method, Functional Interfaces can have a default methods
         */
        public static boolean someDefaultMethod(String x, String y) {
            System.out.println("A static Method");
            return true;
        }
    }

    public static void main(String[] args) {

        boolean s = DefaultMethodDemoInterface.someDefaultMethod("A", "B");

    }
}
