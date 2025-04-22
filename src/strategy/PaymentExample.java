package strategy;

// Использование
public class PaymentExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Выбираем стратегию оплаты
        cart.setPaymentStrategy(new CreditCardStrategy("1234-5678-9012-3456", "123"));
        cart.checkout(100);

        // Меняем стратегию на лету
        cart.setPaymentStrategy(new PayPalStrategy("user@example.com"));
        cart.checkout(50);

        // Еще одна стратегия
        cart.setPaymentStrategy(new CryptoStrategy("0x71C76567ab401B5f676F"));
        cart.checkout(75);
    }
}
