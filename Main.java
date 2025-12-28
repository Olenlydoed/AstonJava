package app;

public class Main {
    public static void main(String[] args) {

        //Builder
        Order order = new Order.Builder()
                .id(1)
                .amount(1200)
                .build();

        //Decorator
        OrderCost cost = new DiscountDecorator(new BaseOrder(order.amount));
        System.out.println("Стоимость с учетом скидки: " + cost.getCost());

        //Strategy
        PaymentStrategy strategy = new CardPayment();

        //Proxy
        PaymentService paymentService = new PaymentProxy(strategy);

        //Chain of Responsibility
        Handler auth = new AuthHandler();
        Handler limit = new LimitHandler();
        auth.setNext(limit);

        if (auth.handle(order.amount)) {
            paymentService.pay(order.amount);
        }

        //Adapter
        DeliveryService delivery = new DeliveryAdapter(new OldDeliverySystem());
        delivery.deliver();
    }
}