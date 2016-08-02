package com.java8.demo.lambda.capturingLambda;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by udoluweera on 8/1/16.
 */
public class CapturingLambdaDemo {

    /**
     * Lambdas provides various implementations for this functional interface
     */
    public interface TradeChecker {
        public boolean check(Trade trade);
    }


    /**
     * First implementation of the Trade Checker.
     * @param trade
     */
    public void checkWhetherTheTradeIsStarted(Trade trade) {
        //Here you provide the implementation of the functional interface as a lambda and then you call that
        //Here you define the behaviour for checking a trade.
        TradeChecker tradeCheckerByFieldValue = (Trade t) -> t.getStarted()?true:false;
        if (tradeCheckerByFieldValue.check(trade) ) {
            System.out.println("Trade has been started....");
            System.out.println("Doing stuffs");
        } else {
            System.out.println("Trade has not been started...");
        }
    }


    /**
     * Second Implementation for the TradeChecker
     *
     * This is an example of a capturing lambda, a Lambda which uses a variable from the enclosing scope.
     * Capturing lambda can expand the functional interface to work with more parameters.
     *
     * @param givenStatus
     */
    public void checkWhetherTheTradeHasGivenStatus(Trade trade, Boolean givenStatus) {

        TradeChecker checkByField = (t) -> t.getStarted().equals(givenStatus) ? Boolean.TRUE:Boolean.FALSE;
        boolean returnValue = checkByField.check(trade);

        System.out.println(" Trade has equal status as provided : " + returnValue);

        //The above is equal to
        TradeChecker tradeCheckOldSchool= new TradeChecker(){
            @Override
            public boolean check(Trade trade) {
                return trade.getStarted().equals(givenStatus)? Boolean.TRUE:Boolean.FALSE;
            }
        };
        tradeCheckOldSchool.check(trade);
    }

    /**
     * Third implementation for the trade checker
     * We are dynamically define behaviour without worring about implementations.
     * Here we check the status and the value as a large trade if the quantity is larger than a given amount.
     *
     * @param status
     * @param quantity
     */
    public void checkWhetherTheTradeHasGivenStatusAndQuantity(Trade trade, Boolean status, Integer quantity){

        /* Defining the business logic to check a large trade, See you can dynamically define business logic with lambda */
        TradeChecker checkForLargeTrades = (t) -> t.getStarted().equals(status) && t.getValue()> quantity ?
                Boolean.TRUE:Boolean.FALSE;
        boolean returnVal = checkForLargeTrades.check(trade);
        System.out.println("Trade has the status checked and more than the checked quantity : " + returnVal);
    }


    public void mutation(Trade tradeObj) {
        TradeChecker mutateObject = (t) -> {
            t.setName("I am mutating the trade object...");
            tradeObj.setName("kkk");
            return true;
        };
        mutateObject.check(tradeObj);
        System.out.println("New Name is : " + tradeObj.getName());

    }

    public static void main(String[] args) {

        CapturingLambdaDemo capturingLambdaDemo = new CapturingLambdaDemo();
        Trade tradeOne = new Trade("Trade1",5000,Boolean.FALSE);

        capturingLambdaDemo.checkWhetherTheTradeIsStarted(tradeOne);
        capturingLambdaDemo.checkWhetherTheTradeHasGivenStatus(tradeOne, Boolean.FALSE);
        capturingLambdaDemo.checkWhetherTheTradeHasGivenStatusAndQuantity(tradeOne,Boolean.FALSE,2000);
        capturingLambdaDemo.checkWhetherTheTradeHasGivenStatusAndQuantity(tradeOne,Boolean.FALSE,24000);

        capturingLambdaDemo.mutation(tradeOne);
    }

}
