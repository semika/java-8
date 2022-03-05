package java8.designpattern.factory;

import java.util.function.Function;
import java.util.function.Supplier;

public class FactoryMain {

    public static void main(String args[]) {
        //OOP approch
        PaymentGatewayFacotry facotry = PaymentGatewayFacotry.of();
        PaymentGateway paymentGateway = facotry.getPaymentGateway("sampath");
        paymentGateway.processTransaction();

        //Improve the code using lambda using suppliers
        Supplier<PaymentGateway> gty = facotry.getPaymentGatewaySuplier("sampath");
        gty.get().processTransaction();


        //Improve the code using lambda using functions. Can pass a paramter too
        Function<CardType, PaymentGateway> function = facotry.getPaymentGatewayFunction("sampath");
        function.apply(CardType.VISA).processTransaction();
    }

}
