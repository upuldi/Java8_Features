package com.java8.demo.lambda.methodReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MethodReferenceOfStaticMethods {

    public interface TestInterface {
        public boolean delegatingMethod(String string);
    }


    public static boolean receiverMethod(String aString) {
        System.out.println("I am the receving method");
        return Boolean.TRUE;
    }


    public static void main(String[] args) {

        /**
         * This example demonstrate method reference of static methods..
         */

        /* This lambda provide an implementation to the TestInterface by simply delegating to a another method. */
        TestInterface withOutMethodReferencing = (s) -> receiverMethod(s);

        /* With Method Referencing */
        TestInterface withMethodReferencing = MethodReferenceOfStaticMethods::receiverMethod;

        withOutMethodReferencing.delegatingMethod("some string");

    }


}
