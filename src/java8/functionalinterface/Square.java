package java8.functionalinterface;

@FunctionalInterface
public interface Square {
    int calculateArea(int x);
    // This is the functional interface. We can have different implementation as we want from
    // the client code. That is the advantage of a functional interface.
}
