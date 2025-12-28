package Adapter;

public class DeliveryAdapter implements DeliveryService {
    private OldDeliverySystem oldSystem;

    public DeliveryAdapter(OldDeliverySystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    public void deliver() {
        oldSystem.ship();
    }
}