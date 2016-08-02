package com.java8.demo.lambda.multipleInheritance;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MultipleInheritenceWithSubInterfaces {


    public interface InterfaceOne {
        public default void method() {
            System.out.println("Parent default method");
        }
    }

    public interface SubInterface extends InterfaceOne {
        public default void method() {
            System.out.println("Child default method");
        }
    }

    /**
     * Here the SubInterface method wins as it is much closer in the inheritance hierarchy.
     */
    class TestClass implements InterfaceOne,SubInterface{
    }

    public static void main(String[] args) {

        TestClass tc = new MultipleInheritenceWithSubInterfaces().new TestClass();
        tc.method();

    }
}
