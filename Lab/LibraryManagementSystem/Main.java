import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        System.out.println("Starting without loading saved data");

        // Add sample data if empty
        if(lib.searchByTitle("").isEmpty()) {
            lib.addItem(new Book("B001","Effective Java","Joshua Bloch"));
            lib.addItem(new Book("B002","Clean Code","Robert Martin"));
            lib.addItem(new Dvd("D001","OOP Lecture","Dr. Smith"));
            lib.registerMember(new Member("M001","Tariro"));
            lib.registerMember(new Member("M002","Farai"));
        }

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1. Add Book 2. Add DVD 3. Register Member 4. Borrow 5. Return 6. Search by title 7. List items 8. List members 9. Overdue 0. Save & Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();
            try {
                switch(choice) {
                    case "1": {
                        System.out.print("id title author (comma separated): ");
                        String[] p = sc.nextLine().split(",");
                        lib.addItem(new Book(p[0].trim(), p[1].trim(), p[2].trim()));
                        break;
                    }
                    case "2": {
                        System.out.print("id title director (comma): ");
                        String[] p = sc.nextLine().split(",");
                        lib.addItem(new Dvd(p[0].trim(), p[1].trim(), p[2].trim()));
                        break;
                    }
                    case "3": {
                        System.out.print("id name (comma): ");
                        String[] p = sc.nextLine().split(",");
                        lib.registerMember(new Member(p[0].trim(), p[1].trim()));
                        break;
                    }
                    case "4": {
                        System.out.print("memberId,itemId: ");
                        String[] p = sc.nextLine().split(",");
                        lib.borrow(p[0].trim(), p[1].trim());
                        break;
                    }
                    case "5": {
                        System.out.println("Returning items is not available.");
                        break;
                    }
                    case "6": {
                        System.out.print("Search text: ");
                        String txt = sc.nextLine();
                        lib.searchByTitle(txt).forEach(System.out::println);
                        break;
                    }
                    case "7":
                        lib.searchByTitle("").forEach(System.out::println);
                        break;
                    case "8":
                        System.out.println("Member listing is not available.");
                        break;
                    case "9":
                        System.out.println("Overdue loans are not available.");
                        break;
                    case "0": {
                        java.lang.reflect.Method saveMethod = lib.getClass().getDeclaredMethod("save");
                        saveMethod.setAccessible(true);
                        saveMethod.invoke(lib);
                        System.out.println("Bye");
                        return;
                    }
                }
            } catch(Exception e) { System.out.println("Error: "+e.getMessage()); }
        }
    }
}