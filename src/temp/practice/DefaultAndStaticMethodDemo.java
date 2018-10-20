package temp.practice;

public class DefaultAndStaticMethodDemo {

    @FunctionalInterface
    interface SomeFunctionalInterface {

        void someInterfaceMethod(String s);

        default boolean aDefaultMethodConsumer(String s) {
            return s.length() > 0 ? true : false;
        }

        static boolean someStaticMethod(String s) {
            return true;
        }
    }


    class SomeClassImplementsFunctionalInterface implements SomeFunctionalInterface {

        @Override
        public void someInterfaceMethod(String s) {

        }


        /**
         * You can override the default methods if you need. Not mandatory
         *
         * @param s
         * @return
         */
        @Override
        public boolean aDefaultMethodConsumer(String s) {
            return false;
        }
    }


    public static void main(String[] args) {


        SomeFunctionalInterface someLambdaForDefaultMethod = SomeFunctionalInterface::someStaticMethod;

    }
}
