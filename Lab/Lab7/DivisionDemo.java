package Lab.Lab7;


import java.util.Scanner;

public class DivisionDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer: ");
            int a = input.nextInt();

            System.out.print("Enter the second integer: ");
            int b = input.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter integers only.");

        } finally {
            input.close();
            System.out.println("Program finished.");
        }
    }
}

    

