package Lab.Lab10;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLinesDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        Path file = Paths.get("myfile.txt");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter line " + i + ": ");
            lines.add(input.nextLine());
        }

        try {
            Files.write(file, lines);
            System.out.println("\nContents of the file:");

            List<String> savedLines = Files.readAllLines(file);
            for (String line : savedLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        input.close();
    }
}
