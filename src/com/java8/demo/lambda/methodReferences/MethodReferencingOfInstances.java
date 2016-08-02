package com.java8.demo.lambda.methodReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MethodReferencingOfInstances {

    public interface TestInterface {
        public boolean delegatingMethod(String string);
    }

    public boolean receiverMethod(String string) {
        System.out.println("Inside the receiver method....");
        return Boolean.TRUE;
    }

    public static void main(String[] args) {

        MethodReferencingOfInstances methodReferencingOfInstances = new MethodReferencingOfInstances();

        /* Without method referencing... */
        TestInterface withoutMethodReferencing = (s) -> methodReferencingOfInstances.receiverMethod(s);

        /* With method referencing... (See the invocation of the method on the instance insted of the Class) */
        TestInterface withMethodReferencing = methodReferencingOfInstances::receiverMethod;
    }

}
