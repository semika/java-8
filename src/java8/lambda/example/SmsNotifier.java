package java8.lambda.example;

import java8.model.Notifier;
import java8.model.Order;

public class SmsNotifier implements Notifier {
    @Override
    public void notify(Order order) {
        //code to send sms notification
    }
}
