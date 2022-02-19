package java8.designpattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMain {

    public static void main(String args[]) {
        //OOP approch
        PaymentGatewayFacotry facotry = new PaymentGatewayFacotry();
        //PaymentGateway paymentGateway = facotry.getPaymentGateway("sampath");
        //paymentGateway.processTransaction();

        //Improve the code using lambda
        Supplier<PaymentGateway> gty = facotry.getPaymentGatewaySuplier("sampath");
        gty.get().processTransaction();
    }
}
