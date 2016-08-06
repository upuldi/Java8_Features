package com.java8.demo.functions.function;

import java.util.function.Function;

/**
 * Created by udoluweera on 8/7/16.
 */
public class ComposingFunction {


    Function<String,Employee> searchEmployeeByName = this::searchEmployeeByName;
    Function<Manager,Employee> searchEmployeeByManager = this::searchEmployeeByManager;
    Function<String,Manager> searchManagerByName = this::searchManagerByName;


    private void composingAndThenDemo() {
        System.out.println("And Then Demo");

        //You can compose two functions using first.andThen(second)
        Function<String, Employee> searchManagerThenSearchEmployee = searchManagerByName.andThen(searchEmployeeByManager);

        Employee employee = searchManagerThenSearchEmployee.apply("manager");
        System.out.println("Returned Employee : " + employee.getName());
    }

    /**
     * See here the first and second one swaps, second.compose.(first)
     */
    private void composingComposeDemo() {
        System.out.println("Composing Demo");

        //You can compose two functions using second.andThen(first)
        Function<String, Employee> searchManagerThenSearchEmployee = searchEmployeeByManager.compose(searchManagerByName);

        Employee employee = searchManagerThenSearchEmployee.apply("manager");
        System.out.println("Returned Employee : " + employee.getName());
    }

    private Employee searchEmployeeByName(String name) {
        System.out.println("Searching employee by name .... " + name);
        return new Employee("name");
    }

    private Employee searchEmployeeByManager(Manager manager) {
        System.out.println("Searching employee by manager .... " + manager.getName());
        return new Employee("name");
    }

    private Manager searchManagerByName(String name) {
        System.out.println("Searching manager by name .... " + name);
        return new Manager("name");
    }

    public static void main(String[] args) {

        new ComposingFunction().composingAndThenDemo();
        new ComposingFunction().composingComposeDemo();
    }


    class Manager {

        String name;

        public Manager(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Employee {
        String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
