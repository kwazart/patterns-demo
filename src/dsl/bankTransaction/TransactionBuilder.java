package dsl.bankTransaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionBuilder {
    private final String accountNumber;
    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionBuilder(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TransactionBuilder deposit(double amount) {
        transactions.add(new Transaction(amount, "DEPOSIT", LocalDateTime.now()));
        return this;
    }

    public TransactionBuilder withdraw(double amount) {
        transactions.add(new Transaction(-amount, "WITHDRAWAL", LocalDateTime.now()));
        return this;
    }

    public TransactionBuilder transfer(double amount, String toAccount) {
        transactions.add(new Transaction(-amount, "TRANSFER to " + toAccount, LocalDateTime.now()));
        return this;
    }

    public TransactionBuilder on(String date) {
        if (!transactions.isEmpty()) {
            Transaction last = transactions.get(transactions.size() - 1);
            last.setTime(LocalDateTime.parse(date + "T00:00:00"));
        }
        return this;
    }

    public TransactionBuilder withNote(String note) {
        if (!transactions.isEmpty()) {
            Transaction last = transactions.get(transactions.size() - 1);
            last.setDescription(last.getDescription() + " - " + note);
        }
        return this;
    }

    public List<Transaction> build() {
        return transactions;
    }
}
