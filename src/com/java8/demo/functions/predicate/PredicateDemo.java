package com.java8.demo.functions.predicate;

import java.util.function.Predicate;

/**
 * Created by udoluweera on 8/2/16.
 */
public class PredicateDemo {

    //The following interface would be similar to the predicate interface
    interface PredicateInterfaceDemo<T>{
        boolean test(T t);
    }

    /**
     * Predicates are used to test a condition,
     * It is nothing but a functional interface provided by the java to test a condition
     * See how easy to provides any number of conditions.
     */

    Predicate<Employee> executiveEmployee = (e) -> e.getSalary()>50000?true:false;
    Predicate<Employee> seniorEmployee = (e) -> e.getId()<100?true:false;
    Predicate<String> isEmptyString = (s) -> s.isEmpty();

    private void testLambda(Employee employee) {
        /**
         * We are checking a condition here,
         */
        System.out.println(" Employee is an executive employee " + executiveEmployee.test(employee));
    }

    public static void main(String[] args) {

        Employee employee = new PredicateDemo().new Employee(99,75000);
        new PredicateDemo().testLambda(employee);
    }


    class Employee {

        int id;
        double salary;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Employee(int id, double salary) {
            this.id = id;
            this.salary = salary;
        }
    }

}
