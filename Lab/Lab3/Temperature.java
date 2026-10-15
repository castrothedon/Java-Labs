package Lab.Lab3;


public final class Temperature {
    private final double kelvin;

    public Temperature(double kelvin) {
        if (!Double.isFinite(kelvin) || kelvin < 0) {
            throw new IllegalArgumentException(
                "Temperature must be finite and at least 0 K"
            );
        }

        this.kelvin = kelvin;
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return getCelsius() * 9.0 / 5.0 + 32;
    }

    public static void main(String[] args) {
        Temperature temperature = new Temperature(300.0);

        System.out.printf(
            "Celsius: %.2f%n", temperature.getCelsius()
        );

        System.out.printf(
            "Fahrenheit: %.2f%n", temperature.getFahrenheit()
        );

        try {
            new Temperature(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}

  