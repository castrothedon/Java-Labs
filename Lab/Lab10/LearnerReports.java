package Lab.Lab10;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Learner {
    private final String name;
    private final int roll;
    private final double gpa;

    Learner(String name, int roll, double gpa) {
        this.name = name;
        this.roll = roll;
        this.gpa = gpa;
    }

    static Learner fromCsv(String line) {
        String[] parts = line.split(",");
        return new Learner(
            parts[0].trim(),
            Integer.parseInt(parts[1].trim()),
            Double.parseDouble(parts[2].trim())
        );
    }

    String gradeBand() {
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        return "C";
    }

    @Override
    public String toString() {
        return "Learner[name=" + name + ", roll=" + roll + ", gpa=" + gpa + "]";
    }
}

public class LearnerReports {
    public static void main(String[] args) {
        Path inputFile = Paths.get("learners.csv");

        try {
            List<Learner> learners = Files.readAllLines(inputFile)
                .stream()
                .filter(line -> !line.trim().isEmpty())
                .filter(line -> !line.toLowerCase().startsWith("name,"))
                .map(Learner::fromCsv)
                .collect(Collectors.toList());

            Map<String, List<Learner>> groups = learners.stream()
                .collect(Collectors.groupingBy(Learner::gradeBand));

            for (String band : Arrays.asList("A", "B", "C")) {
                List<Learner> group = groups.getOrDefault(
                    band, Collections.emptyList()
                );

                List<String> report = group.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());

                Path outputFile = Paths.get("grade_" + band + ".txt");
                Files.write(outputFile, report);

                System.out.println(
                    "Created " + outputFile + ": "
                    + group.size() + " learner(s)"
                );
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid CSV data: " + e.getMessage());
        }
    }
}
