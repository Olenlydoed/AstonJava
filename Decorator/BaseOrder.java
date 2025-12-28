package Decorator;

public class BaseOrder implements OrderCost {
    private int cost;
    public BaseOrder(int cost) {
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }
}