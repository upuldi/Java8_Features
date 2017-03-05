package com.java8.demo.streams.groupingBy.multicolumngroup;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by L078878 on 15/02/2017.
 */
public class Fruit {

    private String name;
    private int qty;
    private BigDecimal price;

    /**
     * This is your Grouping Class
     */
    public static class NameAndQty {

        String name;
        int qty;

        public NameAndQty(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NameAndQty)) return false;
            NameAndQty that = (NameAndQty) o;
            return qty == that.qty &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, qty);
        }

        @Override
        public String toString() {
            return "NameAndQty{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    '}';
        }
    }


    /**
     * This field return a NameAndQty object to group
     * @return
     */
    public NameAndQty getNameAndQty() {
        return new NameAndQty(name,qty);
    }


    public Fruit(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return getQty() == fruit.getQty() &&
                Objects.equals(getName(), fruit.getName()) &&
                Objects.equals(getPrice(), fruit.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQty(), getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
