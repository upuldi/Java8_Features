package temp.practice;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by udoluweera on 9/17/16.
 */
public class LambdaRevisit {

    // inputs -> body
    // (inputs) -> body
    // () -> body

    // x -> x*2
    Function<Integer,Integer> multiplyByTwo = x -> x.intValue() * 2;

    //(x,y) -> x+y
    BiFunction<Integer,Integer,Integer> sumTwoNumbers = (x,y) -> x + y;



    private String emailComposer(String input,Function<String,String> function) {
        return function.apply(input);
    }


    public static void main(String[] args) {

        //Composing a gmail email
        String gmailEmail = new LambdaRevisit().emailComposer("firstName", x -> x + "@gmail.com");
        System.out.println(gmailEmail);
    }

}
