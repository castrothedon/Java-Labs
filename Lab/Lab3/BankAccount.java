package Lab.Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> transactions = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName,
                       double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                "Opening balance cannot be negative"
            );
        }

        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name required");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName.trim();
        this.balance = openingBalance;

        transactions.add(
            "Account opened with balance: " + openingBalance
        );
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive"
            );
        }

        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive"
            );
        }

        if (amount > balance) {
            transactions.add(
                "Withdrawal declined: " + amount
            );
            return false;
        }

        balance -= amount;
        transactions.add("Withdrawn: " + amount);
        return true;
    }

    public List<String> getTransactions() {
        return Collections.unmodifiableList(
            new ArrayList<>(transactions)
        );
    }

    public static void main(String[] args) {
        BankAccount account =
            new BankAccount("ACC-001", "Tendai", 500.00);

        account.deposit(250.00);
        account.withdraw(100.00);

        System.out.println("Balance: " + account.getBalance());
        System.out.println("Transactions:");

        for (String transaction : account.getTransactions()) {
            System.out.println(transaction);
        }

        try {
            account.getTransactions().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Transaction history is protected");
        }
    }
}
