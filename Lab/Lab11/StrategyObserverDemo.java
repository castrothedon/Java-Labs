package Lab.Lab11;


import java.util.ArrayList;
import java.util.List;

// STRATEGY
interface DiscountStrategy {
    double apply(double price);
}

class Checkout {
    private DiscountStrategy strategy;

    Checkout(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    double total(double price) {
        return strategy.apply(price);
    }
}

// OBSERVER
interface GradeListener {
    void onGradePublished(String course, int mark);
}

class GradeBook {
    private final List<GradeListener> listeners = new ArrayList<>();

    void subscribe(GradeListener listener) {
        listeners.add(listener);
    }

    void publish(String course, int mark) {
        for (GradeListener listener : listeners) {
            listener.onGradePublished(course, mark);
        }
    }
}

public class StrategyObserverDemo {
    public static void main(String[] args) {
        Checkout checkout = new Checkout(price -> price);

        System.out.println("Regular: " + checkout.total(200));

        checkout.setStrategy(price -> price * 0.90);
        System.out.println("Student: " + checkout.total(200));

        GradeBook book = new GradeBook();

        book.subscribe((course, mark) ->
            System.out.println("Student portal: " + course + " = " + mark)
        );

        book.subscribe((course, mark) -> {
            if (mark < 50) {
                System.out.println("Advisor alert: " + course + " failed");
            }
        });

        book.publish("OOP", 72);
        book.publish("Databases", 45);
    }
}
