package Lab.Lab7;


public class FinallyDemo {

    static int testMethod() {
        try {
            System.out.println("Inside try");
            return 10;

        } finally {
            System.out.println("Inside finally");
        }
    }

    public static void main(String[] args) {
        int result = testMethod();
        System.out.println("Returned value: " + result);
    }
}
