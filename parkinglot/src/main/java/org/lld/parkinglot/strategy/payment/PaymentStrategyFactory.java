package main.java.org.lld.parkinglot.strategy.payment;

import main.java.org.lld.parkinglot.enums.PaymentType;

public class PaymentStrategyFactory {

    public IPaymentStrategy getPaymentStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case UPI-> new UpiPayment();
            case CREDIT_CARD-> new CreditCardPayment();
            default-> new UpiPayment();
        };
    }
}
