package main.java.org.lld.parkinglot.strategy.payment;

import main.java.org.lld.parkinglot.enums.PaymentType;

public class UpiPayment implements IPaymentStrategy {

    PaymentType paymentType= PaymentType.UPI;

    @Override
    public boolean pay(double amount) {
        System.out.printf("Paid %s via UPI \n", amount);
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
