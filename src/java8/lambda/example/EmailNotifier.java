package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public class EmailNotifier implements Notifier {

    @Override
    public void notifyCustomer(Order order) {
        System.out.print("Sending notification to customer...");
    }
}
