package Lab.Lab10;


import java.util.Comparator;
import java.util.List;

public class StudentAverageDemo {
    private static class Student {
        private final String name;
        private final double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        String name() {
            return name;
        }

        double marks() {
            return marks;
        }
    }

    public static void main(String[] args) {
        List<Student> students = java.util.Arrays.asList(
            new Student("Tariro", 75),
            new Student("Farai", 60),
            new Student("Rudo", 90),
            new Student("Kuda", 80),
            new Student("Nyasha", 55)
        );

        double average = students.stream()
            .mapToDouble(Student::marks)
            .average()
            .orElse(0);

        System.out.println("Class average: " + average);
        System.out.println("Students above average:");

        students.stream()
            .filter(s -> s.marks() > average)
            .map(Student::name)
            .sorted(Comparator.naturalOrder())
            .forEach(System.out::println);
    }
}
