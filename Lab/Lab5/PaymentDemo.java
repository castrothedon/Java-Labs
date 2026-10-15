package Lab.Lab5;

abstract class Payment {
    abstract void process();
}

class CardPayment extends Payment {
    @Override
    void process() {
        System.out.println("Processing card payment");
    }
}

class MobileMoneyPayment extends Payment {
    @Override
    void process() {
        System.out.println("Processing mobile money payment");
    }
}

class PaymentProcessor {
    void pay(Payment payment) {
        payment.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment());
        processor.pay(new MobileMoneyPayment());
    }
}