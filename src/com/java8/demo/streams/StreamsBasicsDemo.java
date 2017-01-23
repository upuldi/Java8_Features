package com.java8.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by udoluweera on 8/8/16.
 */
public class StreamsBasicsDemo {


    private void withStreams(List<Trade> tradeList) {

        //Here everything is nice and clean,
        //Behaviour is injected.
        //The filters accepts a predicate, and based on the predicate they do the filtering..
        List<Trade> largerTrades = tradeList.stream()
                .filter((t)->t.getSize()>10000?true:false)
                .filter(this::isOpenTrade)
                .collect(Collectors.toList());
    }

    private void withoutStreams(List<Trade> tradeList) {

        List<Trade> largeAndOpenTradesList = new ArrayList<>();

        //Here how to do is defined rather than what to do
        // Not supporting for concurrent processing...s
        for (Trade t : tradeList) {
            if((t.getSize()>10000) && this.isOpenTrade(t)) {
                largeAndOpenTradesList.add(t);
            }
        }
    }



    public boolean isOpenTrade(Trade t) {
        return false;
    }


    public static void main(String[] args) {}

    class Trade {

        int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
