package Builder;

public class Order {
    public int id;
    public int amount;

    private Order(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
    }

    public static class Builder {
        private int id;
        private int amount;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}