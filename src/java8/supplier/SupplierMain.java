package java8.supplier;

import java.util.function.Supplier;

public class SupplierMain {

    public static void main(String[] args) {

        Supplier<Double> mysup = () -> {   // Supper is a kind of Function. But this does not get any inputs, only returns a value.
            return 10.0;
        };

        System.out.print(mysup.get());
    }
}
