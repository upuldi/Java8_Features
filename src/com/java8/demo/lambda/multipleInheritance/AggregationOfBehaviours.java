package com.java8.demo.lambda.multipleInheritance;

/**
 * Created by udoluweera on 8/1/16.
 */
public class AggregationOfBehaviours {

    public interface InterfaceOne {
        public default void methodOne() {
            System.out.println("Interface One Method One");
        }
    }

    public interface InterfaceTwo {
        public default void methodTwo() {
            System.out.println("Interface Two Method Two");
        }
    }

    class TestClass implements InterfaceOne,InterfaceTwo {

        /**
         * Only behaviour is allowed to inherit, no state is allowed to inherit.
         * This method aggregate method one and twos behaviour using default methods
         */
        public void methodOneAndTwo() {
            InterfaceOne.super.methodOne();
            InterfaceTwo.super.methodTwo();
        }
    }

    public static void main(String[] args) {
        TestClass tc = new AggregationOfBehaviours().new TestClass();
        tc.methodOneAndTwo();
    }
}
