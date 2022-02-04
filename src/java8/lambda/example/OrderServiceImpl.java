package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public class OrderServiceImpl implements OrderService {
    @Override
    public void placeOrder(Order order, Notifier notifier) {
        //code to place the order
        //send the notificaiton
        notifier.notify();
    }
}
