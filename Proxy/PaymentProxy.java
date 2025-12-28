package Proxy;

import Strategy.PaymentStrategy;

public class PaymentProxy implements PaymentService {
    private RealPaymentService service;
    private PaymentStrategy strategy;

    public PaymentProxy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(int amount) {
        if (service == null) {
            service = new RealPaymentService();
        }
        System.out.println("Логирование платежа");
        strategy.pay(amount);
        service.pay(amount);
    }
}