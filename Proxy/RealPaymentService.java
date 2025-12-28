package Proxy;

public class RealPaymentService implements PaymentService {
    public void pay(int amount) {
        System.out.println("Платеж выполнен");
    }
}