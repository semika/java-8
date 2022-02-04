package java8.model;

@FunctionalInterface
public interface Notifier {
    void notify(Order order);
}
