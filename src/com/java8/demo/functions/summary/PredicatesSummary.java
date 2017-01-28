package com.java8.demo.functions.summary;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by udoluweera on 1/28/17.
 */
public class PredicatesSummary {

    class SomeClass {

        int someInt;

        public int getSomeInt() {
            return someInt;
        }

        public void setSomeInt(int someInt) {
            this.someInt = someInt;
        }
    }

    public boolean predicateDemoMethod(String inputValue, Predicate<String> predicate) {
        return predicate.test(inputValue);
    }

    public boolean biPredicateDemoMethod(String stringValue, Integer intValue, BiPredicate<String,Integer> predicate) {
        return predicate.test(stringValue,intValue);
    }


    public static void main(String[] args) {


        //Predicate takes an argument and returns a boolean value
        //Test() method is predicates used to check whether the predicate is true or not.

        Predicate<SomeClass> someClassPredicate = (o) -> o.getSomeInt() > 100 ? true : false;

        Predicate<String> isNotEmpty = (s) -> !s.isEmpty();
        Predicate<String> isMoreThan10Chars = (s) -> s.length() > 10 ? true : false;

        //Predicates can be joined / OR / negate

        Predicate<String> notEmptyAndMoreThan10Chars = isNotEmpty.and(isMoreThan10Chars);
        Predicate<String> notEmptyOrMoreThan10Chars = isNotEmpty.or(isMoreThan10Chars);
        Predicate<String> notEmptyNor = isNotEmpty.negate();


        PredicatesSummary predicatesSummary = new PredicatesSummary();
        boolean result = predicatesSummary.predicateDemoMethod("12345",isNotEmpty);
        System.out.println(result);

        result = predicatesSummary.predicateDemoMethod("12345678910",isMoreThan10Chars);
        System.out.println(result);

        result = predicatesSummary.predicateDemoMethod("12345",notEmptyAndMoreThan10Chars);
        System.out.println(result);

        result = predicatesSummary.predicateDemoMethod("12345",notEmptyOrMoreThan10Chars);
        System.out.println(result);

        result = predicatesSummary.predicateDemoMethod("12345",notEmptyNor);
        System.out.println(result);


        //Bi Predicates
        //Takes two arguments and returns a boolean value back
        BiPredicate<String,Integer> lengthIsSufficient = (s, i) -> s.length() > i ? true : false;

        result = predicatesSummary.biPredicateDemoMethod("12345",3,lengthIsSufficient);
        System.out.println(result);


        //For Primitives you can use primitive predicates
        IntPredicate someIntPredicate = (i) -> i > 10;
        System.out.println(someIntPredicate.test(9));
        System.out.println(someIntPredicate.test(12));

        DoublePredicate finiteDoubleValue = Double::isFinite;
        boolean res = finiteDoubleValue.test(3.12121212121);
        System.out.println(res);






    }
}
