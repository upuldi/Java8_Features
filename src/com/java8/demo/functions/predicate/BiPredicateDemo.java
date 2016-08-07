package com.java8.demo.functions.predicate;

import java.util.function.BiPredicate;

/**
 * Created by udoluweera on 8/8/16.
 */
public class BiPredicateDemo {

    //Bi Predicates takes two inputs and returns a boolean value
    BiPredicate<Employee,Manager> checkEmployeeHasGivenManager = (e,m) -> e.getManager().equals(m) ? true:false;

    BiPredicate<Employee,Manager> someOtherPredicate = null;

    //Same as normal predicates BiPredicates can be joined
    BiPredicate<Employee,Manager> joinedPredicate = checkEmployeeHasGivenManager.and(someOtherPredicate);

    //OR
    BiPredicate<Employee,Manager> orPredicate = checkEmployeeHasGivenManager.or(someOtherPredicate);

    //Negate
    BiPredicate<Employee,Manager> negate = checkEmployeeHasGivenManager.negate();


    public static void main(String[] args) {

    }


    class Manager {}

    class Employee {

        Manager manager;

        public Manager getManager() {
            return manager;
        }

        public void setManager(Manager manager) {
            this.manager = manager;
        }
    }



}
