package ChainOfResponsibility;

public class LimitHandler extends Handler {
    public boolean handle(int amount) {
        if (amount > 1000) {
            System.out.println("Превышен лимит");
            return false;
        }
        return true;
    }
}