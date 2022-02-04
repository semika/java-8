package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(Order order) {
        // Code to send email notification
    }
}
