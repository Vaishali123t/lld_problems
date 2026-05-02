package main.java.org.lld.parkinglot.strategy.payment;

import main.java.org.lld.parkinglot.enums.PaymentType;

public interface IPaymentStrategy {

    boolean pay(double amount);
    PaymentType getPaymentType();
    void setPaymentType(PaymentType paymentType);
}
