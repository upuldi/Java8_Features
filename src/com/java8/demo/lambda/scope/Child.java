package com.java8.demo.lambda.scope;

/**
 * Created by udoluweera on 8/1/16.
 */
public class Child extends Parent {

    public String field = "LocalField";

    public interface SomeFunctionalInterface {
        public void someMethod(String string);
    }


    public void scopeTestMethod(String field) {

        System.out.println("Method Field : " + field);
        System.out.println("This Field : " + this.field);
        System.out.println("Super Field : " + super.field);

        System.out.println("Lambda Scope Test ");

        SomeFunctionalInterface test = (s) -> {
            System.out.println("Inside Lambda : s > " + s );
            System.out.println("Inside Lambda : field > " + field );
            System.out.println("Inside Lambda : this > " + this.field );
            System.out.println("Inside Lambda : super > " + super.field );
        };
        test.someMethod(field);
    }

    public static void main(String[] args) {

        Child child = new Child();
        child.scopeTestMethod("Method Parameter");

    }
}
