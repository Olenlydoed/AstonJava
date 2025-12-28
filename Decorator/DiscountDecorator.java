package Decorator;

public class DiscountDecorator implements OrderCost {
    private OrderCost order;
    public DiscountDecorator(OrderCost order) {
        this.order = order;
    }
    public int getCost() {
        return order.getCost() - 100;
    }
}