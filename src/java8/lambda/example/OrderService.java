package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public interface OrderService {
    void placeOrder(Order order, Notifier notifier);
}
