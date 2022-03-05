package java8.designpattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public final class PaymentGatewayFacotry {

    private static PaymentGatewayFacotry instance = null;

    private static Map<String, Supplier<PaymentGateway>> paymentGatewaySupplierFactoryMap = new HashMap<>(2);
    private static Map<String, Function<CardType, PaymentGateway>> paymentGatewayFunctionFactoryMap = new HashMap<>(2);

    static {
        //initialize supplier map
        //paymentGatewaySupplierFactoryMap.put("sampath", () -> new SampathPaymentGateway());
        //paymentGatewaySupplierFactoryMap.put("hnb", () -> new HnbPaymentGateway());

        //initialize supplier map. This case no need to pass parameters.
        paymentGatewaySupplierFactoryMap.put("sampath", SampathPaymentGateway::new);
        paymentGatewaySupplierFactoryMap.put("hnb", HnbPaymentGateway::new);

        //If we want to pass a parameter when creating an  instance of a class, need to use a funcion.
        paymentGatewayFunctionFactoryMap.put("sampath", cardType -> new SampathPaymentGateway(cardType));
        paymentGatewayFunctionFactoryMap.put("hnb", (CardType cardType) -> new HnbPaymentGateway(cardType));

    }

    //Factory method - Legacy
    public PaymentGateway getPaymentGateway(String name) {
        switch (name) {
            case "sampath":
                return SampathPaymentGateway::new; //Constructor reference same as method reference
            case "hnb":
                return HnbPaymentGateway::new;
            default:
                return HnbPaymentGateway::new;
        }
    }

    //Factory method which returns a supplier
    public Supplier<PaymentGateway> getPaymentGatewaySuplier(String name) {
       return paymentGatewaySupplierFactoryMap.get(name);
    }

    //Factory method which returns a function
    public Function<CardType, PaymentGateway> getPaymentGatewayFunction(String name) {
        return paymentGatewayFunctionFactoryMap.get(name);
    }

    public static PaymentGatewayFacotry of() {
        return new PaymentGatewayFacotry();
    }
}
