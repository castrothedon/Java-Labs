package Lab.Lab2;

public class Circle {
    double radius;

    
    public Circle(double radius) {
        this.radius = radius;
    }


    public Circle() {
        this.radius = 1.0;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.printf(
            "Radius: %.1f, Area: %.2f%n",
            radius, area()
        );
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();

        c1.display();
        c2.display();
    }
}
