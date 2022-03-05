package java8.designpattern.factory;

public class SampathPaymentGateway implements PaymentGateway {

    private CardType cardType;

    public SampathPaymentGateway() {
        System.out.println("Creating instance of SampathPaymentGateway....");
    }

    public SampathPaymentGateway(CardType cardType) {
        this.cardType = cardType;
        System.out.println("Creating instance of SampathPaymentGateway....");
    }

    @Override
    public void processTransaction() {
        System.out.println("Handling payment through sampath gateway");
    }
}
