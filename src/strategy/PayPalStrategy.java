package strategy;

// Конкретная стратегия оплаты
class PayPalStrategy implements PaymentStrategy {
    private final String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal account " + email);
    }
}
