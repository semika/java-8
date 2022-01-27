package java8.functionalinterface;

import java.util.function.Function;

@FunctionalInterface
public interface StringLengthFunction<String, Integer> extends Function<String, Integer> {
    Integer apply(String s);
}
