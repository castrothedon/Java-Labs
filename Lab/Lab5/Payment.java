package Lab.Lab5;

public class Payment {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment());
        processor.pay(new MobileMoneyPayment());
    }
}

class CardPayment extends Payment {
    void process() {
        System.out.println("Processing card payment");
    }
}

class MobileMoneyPayment extends Payment {
    void process() {
        System.out.println("Processing mobile money payment");
    }
}

class PaymentProcessor {
    void pay(Payment payment) {
        if (payment instanceof CardPayment) {
            ((CardPayment) payment).process();
        } else if (payment instanceof MobileMoneyPayment) {
            ((MobileMoneyPayment) payment).process();
        } else {
            throw new IllegalArgumentException(
                "Unsupported payment type"
            );
        }
    }
}
