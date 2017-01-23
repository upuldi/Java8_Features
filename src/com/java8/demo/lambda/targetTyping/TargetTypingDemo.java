package com.java8.demo.lambda.targetTyping;

/**
 * Created by udoluweera on 8/1/16.
 */
public class TargetTypingDemo {


    @FunctionalInterface
    public interface EmailAddress {
        public String constructEmailAddress(String string);
    }

    @FunctionalInterface
    public interface PostCode {
        public String constructPostCode(String string);
    }

    @FunctionalInterface
    public interface FunctionalInterfaceWithNoInputParams {
        public String noInputParamsMethod();
    }

    @FunctionalInterface
    public interface WithManyParams {
        public String manyParams(String string, Integer integerVal);
    }

    public String getEmailAddress(String uniqueId, EmailAddress emailAddress) {
        //Do some business logic to create an email using the inputs
        return emailAddress.constructEmailAddress(uniqueId);
    }

    public void createEmailAddressWithFirstNameAndLastName(String firstName,String lastName) {
        // The below lambda is fine as it passes a one parameter to the functional interface and
        // uses capturing lambda to get the last name
        EmailAddress nameBasedEmailAddress = (first) -> first+ lastName + "@gmail.com";

        //But It can not be define as below, as you can pass more than one parameter to the functional interface method
        EmailAddress fulNameEmailAddress  = (first/*,last*/) -> first /*+ last */+ "@gmail.com";

    }

    public static void main(String[] args) {

    /*
         For Target Type inference the compile checks the method signature of the interface method,
         if it matches the compile allows it.
    */

        EmailAddress firstNameBasedEmail = firstName -> firstName + "@gmail.com";

    /*
        This below line of code results an error because, The inputs should matchs the method signature in the functional
        interface, And again the functional interface can not have more than one public methods.
        EmailAddress fullNameBasedEmail = (String firstName,String lastName) -> firstName + lastName + "@gmail.com";
    */
        PostCode defaultPostCode =  postCode -> postCode + "000";

        //Passing to methods

        /* When passing to a method which accept functional interface as a input  */
        TargetTypingDemo targetTypingDemo = new TargetTypingDemo();

        // Here you are passing the behaviour of how to construct the email address
        targetTypingDemo.getEmailAddress("MyLastName", (String lastName) -> lastName + "@yahoo.com");
        //You can omit the input types
        targetTypingDemo.getEmailAddress("MyFirstName", firstName -> firstName + "@gmail.com");


        // The lambda expressions are similar to the code below.
        targetTypingDemo.getEmailAddress("MyFirstName", new EmailAddress() {
            @Override
            public String constructEmailAddress(String firstName) {
                return firstName + "@gmail.com";
            }
        });


        //With no inputs
        FunctionalInterfaceWithNoInputParams noInputParams = () -> "SomeDmmyConstantBehaviour";

        //Target Type of a complex functional interface with accept more than one inputs.
        WithManyParams manyParams = (String stringVal,Integer integerVal) -> {
            return stringVal + integerVal;
        };
    }
}
