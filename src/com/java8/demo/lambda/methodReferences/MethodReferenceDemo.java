package com.java8.demo.lambda.methodReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MethodReferenceDemo {

    /**
     * Some POJO class
     */
    class SomeObject {
        public void methodInSomeObject() {
            System.out.println("A method in some object.....");
        }
    }

    @FunctionalInterface
    public interface SomeInterface {
        public void someMethod(SomeObject someObject);
    }

    /**
     * Method references demo
     *
     */
    public void methodReferenceTest() {
        SomeInterface methodReferencingLambda = SomeObject::methodInSomeObject;
        methodReferencingLambda.someMethod(new MethodReferenceDemo.SomeObject());
    }


    public static void main(String[] args) {

        //Method reference is when a lambda is just invoking a method of the target object
        SomeInterface methodReferencingLambdaOne = (o) -> o.methodInSomeObject();
        SomeInterface methodReferencingLambdaTwo = (SomeObject o) -> o.methodInSomeObject();

        //This is the method reference syntax
        //ClassName::delegating method name
        SomeInterface methodReferencingLambda = SomeObject::methodInSomeObject;

        new MethodReferenceDemo().methodReferenceTest();
    }
}
