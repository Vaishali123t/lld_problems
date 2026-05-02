package main.java.org.lld.parkinglot.strategy.payment;

import main.java.org.lld.parkinglot.enums.PaymentType;

public class CreditCardPayment implements IPaymentStrategy {

    PaymentType paymentType = PaymentType.CREDIT_CARD;

    @Override
    public boolean pay(double amount) {
        System.out.printf("Paid %s via CREDIT_CARD \n", amount);
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Override
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
