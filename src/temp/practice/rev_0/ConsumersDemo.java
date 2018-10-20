package temp.practice.rev_0;

import java.util.function.*;


public class ConsumersDemo {

    private String someField;

    public static ConsumersDemo aMethodWhichReurnsObject(String someString) {
        return new ConsumersDemo(someString);
    }

    public ConsumersDemo(String someField) {
        this.someField = someField;
    }

    public static void main(String[] args) {

        Consumer<String> someConsumer = (s) -> System.out.println("I received something.... + " + s);
        someConsumer.accept("Test message....");

//        Function<Function<String,Integer>,String> someFunction = (f(a,b)) -> return "something";

        Function<String, Integer> someBasicFunction = (s) -> 100;
        Function<Function<String, Integer>, Integer> anotherFunction = (f) -> f.apply("SomeString");

        Integer someValue = anotherFunction.apply((s) -> {
            System.out.println("UPUL.......");
            return 500;
        });
        System.out.println(someValue);

        Function<String, ConsumersDemo> someFunTest = ConsumersDemo::new;
        Function<String, ConsumersDemo> anotherFunTest = ConsumersDemo::aMethodWhichReurnsObject;

        Predicate<String> thisIsAStringPredicate = (s) -> s.equalsIgnoreCase("something") ? true : false;
        IntPredicate someIntPredicate = (i) -> i > 10;

        IntFunction<Double> someIntFunction = null; //Primitive int to object double
        IntToDoubleFunction someINtTODoubleFunction = null; //Primitive int to primitive double

        IntFunction<String> someIntFunctionFromString = Integer::toString;
        ToIntFunction<Boolean> returnsAnInt = (b) -> 10;
        BinaryOperator<String> binaryStringOperator = (p, q) -> p + q;
        IntUnaryOperator intUnaryOperator = (i) -> 10;
        IntBinaryOperator intBinary = (x, y) -> x + y;
    }


}
