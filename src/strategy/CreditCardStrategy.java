package strategy;

// Конкретная стратегия оплаты
class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    private final String cvv;

    public CreditCardStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid with credit card " + cardNumber);
    }
}
