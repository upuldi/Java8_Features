package com.java8.demo.lambda.multipleInheritance;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MultipleInheritanceWithDefaultMethods {

    public interface InterfaceOne {
        public default void method() {
            System.out.println("Interface One Method");
        }
    }

    public interface InterfaceTwo {
        public default void method() {
            System.out.println("Interface Two Method");
        }
    }

    /**
     * If the class inherits the same default method from more than one interfaces the class has to explicitly defined it
     *
     */
    class TestClass implements InterfaceOne, InterfaceTwo {
        //You have to explicitly provide a behaviour
        @Override
        public void method() {
            InterfaceOne.super.method();
            InterfaceTwo.super.method();
        }
    }

    public static void main(String[] args) {
        TestClass tc = new MultipleInheritanceWithDefaultMethods().new TestClass();
        tc.method();
    }
}
