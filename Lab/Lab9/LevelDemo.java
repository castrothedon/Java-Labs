package Lab.Lab9;


enum Level {
    LOW, MEDIUM, HIGH
}

public class LevelDemo {
    public static void main(String[] args) {
        Level[] levels = Level.values();

        for (Level level : levels) {
            switch (level) {
                case LOW:
                    System.out.println("LOW: Keep monitoring.");
                    break;
                case MEDIUM:
                    System.out.println("MEDIUM: Be careful.");
                    break;
                case HIGH:
                    System.out.println("HIGH: Take immediate action.");
                    break;
            }
        }
    }
}
