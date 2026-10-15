package Lab.Lab8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        Collections.addAll(numbers,
            12, 5, 20, 8, 15, 3, 25, 10, 7, 18);

        int sum = 0;
        int maximum = numbers.get(0);

        for (int number : numbers) {
            sum += number;

            if (number > maximum) {
                maximum = number;
            }
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + maximum);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
    }
}

