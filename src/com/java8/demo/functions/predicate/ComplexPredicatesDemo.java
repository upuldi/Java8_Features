package com.java8.demo.functions.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by udoluweera on 8/2/16.
 */
public class ComplexPredicatesDemo {


    /**
     * Simple Predicates can be combines as follows
     */
    Predicate<Trade> bigTrade = (t) -> t.getSize()>10000?true:false;
    Predicate<Trade> openTrade = Trade::isStatus;

    Predicate<Trade> bigAndOpenTrade = (t) -> t.getSize() > 1000 && t.isStatus() ? true:false;

    //AND
    /* The same statement can be written using methods in the Predicate class as follows */
    Predicate<Trade> bigAndOpenTradeElegant = bigTrade.and(openTrade);

    //OR
    Predicate<Trade> bigOrOpenTrade = bigTrade.or(openTrade);

    //Negate
    /* This predicate will match all the closed trades */
    Predicate<Trade> closedTrades = openTrade.negate();

    //Equal
    //Assume if you are searching a trade from a collection of trades
    Trade searchingTrade = new Trade (999,false);
    //Note the static method
    Predicate<Trade> searchingATrade =Predicate.isEqual(searchingTrade);
    //How to search them
    List<Trade> tradeList = Arrays.asList(new Trade[10]);
    //for(Trade t : tradeList) {
    //  if (seatchingATrade.test(t)) { System.out.println("Trade found"); }
    //}

    public static void main(String[] args) {

    }


    class Trade {

        int size;
        boolean status;

        public Trade(int size, boolean status) {
            this.size = size;
            this.status = status;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

}
