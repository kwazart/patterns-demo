package dsl.bankTransaction;

import java.util.List;

public class BankDSL {
    // DSL точка входа
    public static TransactionBuilder forAccount(String accountNumber) {
        return new TransactionBuilder(accountNumber);
    }

    public static void main(String[] args) {
        List<Transaction> transactions = forAccount("123456789")
                .deposit(1000.00)
                    .on("2025-05-01")
                    .withNote("Salary")
                .withdraw(50.00)
                    .on("2025-05-02")
                    .withNote("Coffee")
                .transfer(200.00, "987654321")
                    .on("2025-05-03")
                    .withNote("Rent payment")
                .build();

        // Вывод всех транзакций
        transactions.forEach(System.out::println);

        // Расчет баланса
        double balance = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Final balance: " + balance);
    }
}
