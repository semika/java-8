package java8.designpattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class PaymentGatewayFacotry {

    private static PaymentGatewayFacotry instance = null;

    private static Map<String, Supplier<PaymentGateway>> paymentGatewaySupplierFactoryMap = new HashMap<>(2);

    static {
        //initialize supplier map
        paymentGatewaySupplierFactoryMap.put("sampath", () -> new SampathPaymentGateway());
        paymentGatewaySupplierFactoryMap.put("hnb", () -> new HnbPaymentGateway());
    }

    //Factory method
    public Supplier<PaymentGateway> getPaymentGatewaySuplier(String name) {
       return paymentGatewaySupplierFactoryMap.get(name);
    }

    public static PaymentGatewayFacotry of() {
        return new PaymentGatewayFacotry();
    }
}
