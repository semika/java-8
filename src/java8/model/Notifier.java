package java8.model;

@FunctionalInterface
public interface Notifier {
    void notifyCustomer(Order order);
}
