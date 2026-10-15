package Lab.Lab2;

public class Employee {
    private static int nextId = 1;

    private final int employeeId;
    private String name;
    private double salary;

    
    public Employee(String name, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.salary = salary;
    }

    
    public Employee(String name) {
        this(name, 0.0);
    }

    
    public Employee() {
        this("Unknown", 0.0);
    }

    
    public Employee(Employee other) {
        this(other.name, other.salary);
    }

    public void display() {
        System.out.printf(
            "ID: %d, Name: %s, Salary: %.2f%n",
            employeeId, name, salary
        );
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tariro", 1200.0);
        Employee e2 = new Employee("Kudzai");
        Employee e3 = new Employee();
        Employee e4 = new Employee(e1);

        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
