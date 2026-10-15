package Lab.Lab5;

public class Payroll {
    static class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculatePay() {
        return baseSalary;
    }
}

static class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }
}

static class Developer extends Employee {
    private int overtimeHours;
    private static final double OVERTIME_RATE = 25.0;

    public Developer(String name, double salary, int overtimeHours) {
        super(name, salary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * OVERTIME_RATE;
    }
}

static class Intern extends Employee {
    public Intern(String name, double stipend) {
        super(name, stipend);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }
}

public static class PayrollDemo {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Rudo", 500)
        };

        double total = 0;

        for (Employee employee : employees) {
            double pay = employee.calculatePay();
            System.out.printf("%s: %.2f%n",
                              employee.name, pay);
            total += pay;
        }

        System.out.printf("Total payroll: %.2f%n", total);
    }
}
}
