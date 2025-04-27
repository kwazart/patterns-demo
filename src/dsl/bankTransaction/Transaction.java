package dsl.bankTransaction;

import java.time.LocalDateTime;

public class Transaction {
    private final double amount;
    private String description;
    private LocalDateTime time;

    public Transaction(double amount, String description, LocalDateTime time) {
        this.amount = amount;
        this.description = description;
        this.time = time;
    }

    // Getters and setters
    public void setTime(LocalDateTime time) { this.time = time; }
    public void setDescription(String desc) { this.description = desc; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return time.toLocalDate() + ": " + description + " " + amount;
    }
}