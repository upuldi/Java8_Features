package com.java8.demo.lambda.methodReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MethodReferencingOnArbitraryTypes {

    public interface TestInterface {
        public boolean delegatingMethod(String string);
    }

    public static void main(String[] args) {

        TestInterface withoutMethodReferencing = (s) -> new MyArbitraryType().receivingInstanceMethod(s);
        withoutMethodReferencing.delegatingMethod("string");

        //With method referencing....
        TestInterface withMethodReferencing = new MyArbitraryType()::receivingInstanceMethod;
        withMethodReferencing.delegatingMethod("string");
        //OR for static
        TestInterface withMethodRefForStatic = MyArbitraryType::receivingStaticMethod;
        withMethodRefForStatic.delegatingMethod("string");
    }
}
