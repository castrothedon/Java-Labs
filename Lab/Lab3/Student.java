package Lab.Lab3;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Student name is required"
            );
        }
        this.name = name.trim();
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100"
            );
        }
        this.marks = marks;
    }

    public static void main(String[] args) {
        Student s = new Student("Castro", 85);

        System.out.println("Name: " + s.getName());
        System.out.println("Marks: " + s.getMarks());

        try {
            s.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("Final marks: " + s.getMarks());
        System.out.println("Grade: " + s.getGrade());
    }

    public char getGrade() {
        if (marks >= 80) {
            return 'A';
        } else if (marks >= 70) {
            return 'B';
        } else if (marks >= 50) {
            return 'C';
        } else {
            return 'F';
        }
    }
}

