package Strategy;

public class CardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Оплата картой: " + amount);
    }
}