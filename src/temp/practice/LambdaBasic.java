package temp.practice;


/**
 * Created by udoluweera on 1/24/17.
 */

class UtilClass {
    static boolean checkMethod(String someSting) { return someSting.length() > 5 ? true : false;}
}

public class LambdaBasic {

    @FunctionalInterface
    interface SomeFunctionalInterface {
        boolean somePredicate(String someString);
    }

    @FunctionalInterface
    interface SomeFunctionalSupplier {
        SomeObjectClass someSupplier(String x);
    }

    @FunctionalInterface
    interface AnotherFunctionalSupplier {
        AnotherObjectClass anotherSupplierWhichAcceptTwoParameters(String x,int y);
    }


    public static void main(String[] args) {

        //Here we are defining lambdas
        SomeFunctionalInterface someLambdaExpression  = (String s) -> s.length() > 2 ? true:false;

        //Definition of the type is not mandatory
        SomeFunctionalInterface moreElegantExpression  = (s) -> s.length() > 2 ? true:false;

        //Since there is only one method call
        SomeFunctionalInterface moreElegantExpressionWhenCallingSingleMethod  = UtilClass::checkMethod;

        //Constructor reference
        SomeFunctionalSupplier withOneArgumentAnotherWay = (s) -> new SomeObjectClass(s);
        SomeFunctionalSupplier withOneArgumentElegantWay = SomeObjectClass::new; //Here we don't provides the passing parameter

        AnotherFunctionalSupplier withTwoArgumentConstructor = (s,i) -> new AnotherObjectClass(s,i);
        AnotherFunctionalSupplier withTwoArgumentConstructorMoreElegant  = AnotherObjectClass::new;







    }
}
