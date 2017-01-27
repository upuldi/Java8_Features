package temp.practice;

public class FunInterface {

    @FunctionalInterface
    interface SomeFunctionalInterface {
        int someIntFunction(int x, int y);
    }

    private void someFunctionUser(int x, int y, SomeFunctionalInterface someFunction) {
        System.out.println(someFunction.someIntFunction(x,y));
    }



    public static void main(String[] args) {

        FunInterface someDemo = new FunInterface();

        //Calling the function using the parameters
        someDemo.someFunctionUser(10,20, (x,y) -> x * y );
        //Another behaviour
        someDemo.someFunctionUser(40,8, (x,y) -> x/y);



    }
}
