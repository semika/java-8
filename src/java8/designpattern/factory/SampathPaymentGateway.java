package java8.designpattern.factory;

public class SampathPaymentGateway implements PaymentGateway {

    public SampathPaymentGateway() {
        System.out.print("Creating instance of SampathPaymentGateway....");
    }

    @Override
    public void processTransaction() {
        System.out.println("Handling payment through sampath gateway");
    }
}
