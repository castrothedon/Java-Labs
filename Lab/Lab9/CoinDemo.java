package Lab.Lab9;


import java.util.ArrayList;
import java.util.List;

enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class CoinDemo {

    static List<Coin> fewestCoins(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative."
            );
        }

        List<Coin> result = new ArrayList<>();
        Coin[] coins = Coin.values();

        // Process from largest denomination to smallest.
        for (int i = coins.length - 1; i >= 0; i--) {
            Coin coin = coins[i];

            while (amount >= coin.getValue()) {
                result.add(coin);
                amount -= coin.getValue();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int amount = 63;
        List<Coin> coins = fewestCoins(amount);

        System.out.println("Amount: " + amount);
        System.out.println("Coins: " + coins);
        System.out.println("Number of coins: " + coins.size());
    }
}
