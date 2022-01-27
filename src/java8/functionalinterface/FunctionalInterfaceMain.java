package java8.functionalinterface;

import java.util.function.Function;

public class FunctionalInterfaceMain {

    public static void main(String args[]) {
        // Implementation one - client one
        Square s1 = (int y) -> y*y;
        print(s1, 6);

        // We can have different implementation as far as we comply with method
        // signature. Signature in the sense, we should pass integer and return integer too.

        // Implementation two - client two
        Square s2 = (int z) -> z*z*z;
        print(s2, 5);

        //Function
        StringLengthFunction<String , Integer> fun = (String s) -> s.length();
        System.out.println(fun.apply("semika"));

        methodWithFunctionAsParameter(fun);
    }

    private static void print(Square s, Integer num) {
        //This code behaves like generic
        System.out.println(s.calculateArea(num));
    }

    private static void methodWithFunctionAsParameter(Function<String, Integer> function) {
        System.out.println(function.apply("semika"));
    }
}
