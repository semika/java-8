package java8.designpattern.factory;

public class HnbPaymentGateway implements PaymentGateway {

    private CardType cardType;

    public HnbPaymentGateway() {
        System.out.println("Creating Instance of HnbPaymentGateway ...");
    }

    public HnbPaymentGateway(CardType cardType) {
        this.cardType = cardType;
        System.out.println("Creating Instance of HnbPaymentGateway ...");
    }

    @Override
    public void processTransaction() {
        System.out.println("Handling payment through HNB gateway");
    }
}
