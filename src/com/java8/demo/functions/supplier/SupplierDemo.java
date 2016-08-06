package com.java8.demo.functions.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by udoluweera on 8/2/16.
 */
public class SupplierDemo {

    /**
     * Supplier doesn't take any arguments but returns a result.
     */

    /**
     * This is how the supplier interface looks like
    * */
    interface SupplierInterfaceDemo<T> {
        public T get();
    }

    //It just supply, in input parameters are needed...
    Supplier<Vehicle> getToyotaLimitedEdition = () -> new Vehicle("Toyota",555);

    //This one invokes the default constructor. Constructor referencing is used here.
    Supplier<Vehicle> getToyotaLimitedEdition2 = Vehicle::new;

    /* See here the supplier type is a list, if you want to return a list you have to expect a list */
    Supplier<List<Vehicle>> vehicleSupplier = () -> Arrays.asList(new Vehicle("Toyota", 100), new Vehicle("Honda", 200));

    public void supplierTest() {
        System.out.println(" Name is : " + getToyotaLimitedEdition.get().getName());
    }

    public static void main(String[] args) {
        new SupplierDemo().supplierTest();
    }

    class Vehicle {
        String name;
        int price;

        public Vehicle() {
        }

        public Vehicle(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }



}
