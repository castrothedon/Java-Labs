package Lab.Lab2;

public class Temperature {

    private final double celsius;

    // Private constructor: objects are created through factory methods
    private Temperature(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException(
                "Temperature cannot be below absolute zero."
            );
        }
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return new Temperature(celsius);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(68);

        System.out.printf(
            "First temperature: %.2f C, %.2f F%n",
            t1.getCelsius(), t1.getFahrenheit()
        );

        System.out.printf(
            "Second temperature: %.2f C, %.2f F%n",
            t2.getCelsius(), t2.getFahrenheit()
        );
    }
}
