package ChainOfResponsibility;

public class AuthHandler extends Handler {
    public boolean handle(int amount) {
        System.out.println("Проверка авторизации");
        return next == null || next.handle(amount);
    }
}