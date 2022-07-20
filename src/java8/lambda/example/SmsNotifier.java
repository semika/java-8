package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public class SmsNotifier implements Notifier {
    @Override
    public void notifyCustomer(Order order) {
        System.out.println("Sending notification to customer via SMS....");
    }
}
