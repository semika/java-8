package java8.lambda.example;

import java8.model.Customer;
import java8.model.Notifier;
import java8.model.Order;
import java.util.function.Function;

import com.sun.tools.corba.se.idl.constExpr.Or;

public class OrderMain {

    public static void main(String args[]) {

        //OOP approch
        //Assume we have an instanc eof order service
        OrderService orderService = new OrderServiceImpl();
        //Assume we have the order object
        Order order = new Order();
        //Assume we have the customer object
        Customer customer = new Customer();

        Notifier notifier = null;
        if (customer.getNotificationPreference().equals("SMS")) {
            notifier = new SmsNotifier();
        } else {
            notifier = new EmailNotifier();
        }

        orderService.placeOrder(order, notifier);


        // functional approach.
        if (customer.getNotificationPreference().equals("SMS")) {
            orderService.placeOrder(order, (Order odr) -> {
                //code to send SMS
            });
        } else {
            orderService.placeOrder(order, (Order odr) -> {
                //code toe send email
            });
        }
    }
}
