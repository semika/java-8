package java8.functionalinterface;

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
    }

    private static void print(Square s, Integer num) {
        //This code behaves like generic
        System.out.println(s.calculateArea(num));
    }
}
