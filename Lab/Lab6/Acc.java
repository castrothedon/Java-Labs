package Lab.Lab6;

public class Acc {
abstract static class Account {
    protected double balance;

    Account(double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                "Opening balance cannot be negative"
            );
        }
        balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive"
            );
        }
        balance += amount;
    }

    public abstract double monthlyFee();

    public double getBalance() {
        return balance;
    }
}

static class SavingsAccount extends Account {
    SavingsAccount(double openingBalance) {
        super(openingBalance);
    }

    @Override
    public double monthlyFee() {
        return 2.00;
    }
}

static class CurrentAccount extends Account {
    CurrentAccount(double openingBalance) {
        super(openingBalance);
    }

    @Override
    public double monthlyFee() {
        return 10.00;
    }
}

public static class AccountDemo {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(100);
        Account current = new CurrentAccount(200);

        savings.deposit(50);
        current.deposit(30);

        System.out.printf(
            "Savings balance: %.2f, monthly fee: %.2f%n",
            savings.getBalance(), savings.monthlyFee()
        );

        System.out.printf(
            "Current balance: %.2f, monthly fee: %.2f%n",
            current.getBalance(), current.monthlyFee()
        );
    }
}
    
}
