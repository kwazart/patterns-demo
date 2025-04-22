package strategy;

// Конкретная стратегия оплаты
class CryptoStrategy implements PaymentStrategy {
    private final String walletAddress;

    public CryptoStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid with crypto to address " + walletAddress);
    }
}