import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private static final Map<String, Loan> ACTIVE_LOANS_BY_ITEM = new HashMap<>();

    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();
    private final LibraryStorage storage;

    public Library() throws IOException {
        storage = new LibraryStorage();
        load();
    }

    static int getActiveLoanCountForMember(String memberId) {
        int count = 0;
        for (Loan loan : ACTIVE_LOANS_BY_ITEM.values()) {
            if (loan.isActive() && loan.getMemberId().equals(memberId)) count++;
        }
        return count;
    }

    public void addItem(LibraryItem item) throws IOException {
        if (items.containsKey(item.getId())) throw new IllegalArgumentException("Item ID already exists.");
        items.put(item.getId(), item);
        save();
    }

    public void registerMember(Member member) throws IOException {
        if (members.containsKey(member.getId())) throw new IllegalArgumentException("Member ID already exists.");
        members.put(member.getId(), member);
        save();
    }

    public void borrow(String memberId, String itemId)
            throws IOException, ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (member == null) throw new IllegalArgumentException("No member found with ID " + memberId);
        if (item == null) throw new IllegalArgumentException("No item found with ID " + itemId);

        item.borrow(member);
        Loan loan = Loan.create(item, member);
        loans.add(loan);
        ACTIVE_LOANS_BY_ITEM.put(itemId, loan);
        save();
        System.out.println("Borrow successful. Due date: " + loan.getDueDate());
    }

    public void giveBack(String itemId) throws IOException {
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("No item found with ID " + itemId);
        Loan loan = ACTIVE_LOANS_BY_ITEM.get(itemId);
        if (loan == null || !loan.isActive()) throw new IllegalArgumentException("This item has no active loan.");

        loan.markReturned();
        item.giveBack();
        ACTIVE_LOANS_BY_ITEM.remove(itemId);
        save();
        System.out.println("Return successful.");
    }

    public List<LibraryItem> getItems() {
        return items.values().stream()
            .sorted(Comparator.comparing(LibraryItem::getId))
            .collect(Collectors.toList());
    }

    public List<Member> getMembers() {
        return members.values().stream()
            .sorted(Comparator.comparing(Member::getId))
            .collect(Collectors.toList());
    }

    public List<Loan> getOverdueLoans() {
        return loans.stream().filter(Loan::isOverdue)
            .sorted(Comparator.comparing(Loan::getDueDate))
            .collect(Collectors.toList());
    }

    public List<LibraryItem> searchByTitle(String query) {
        String q = query.toLowerCase(Locale.ROOT);
        return items.values().stream()
            .filter(item -> item.getTitle().toLowerCase(Locale.ROOT).contains(q))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .collect(Collectors.toList());
    }

    public List<Loan> getLoans() {
        return new ArrayList<>(loans);
    }

    private void load() throws IOException {
        for (String line : storage.readItems()) {
            if (line.isBlank()) continue;
            try {
                String[] p = line.split(",", 3);
                LibraryItem item = switch (p[0]) {
                    case "BOOK" -> new Book(p[1], p[2]);
                    case "DVD" -> new Dvd(p[1], p[2]);
                    default -> null;
                };
                if (item != null) items.put(item.getId(), item);
            } catch (RuntimeException ex) {
                System.err.println("Skipping invalid item row: " + line);
            }
        }

        for (String line : storage.readMembers()) {
            if (line.isBlank()) continue;
            try {
                String[] p = line.split(",", 2);
                Member member = new Member(p[0], p[1]);
                members.put(member.getId(), member);
            } catch (RuntimeException ex) {
                System.err.println("Skipping invalid member row: " + line);
            }
        }

        for (String line : storage.readLoans()) {
            if (line.isBlank()) continue;
            try {
                Loan loan = Loan.fromCsv(line);
                loans.add(loan);
                if (loan.isActive()) {
                    LibraryItem item = items.get(loan.getItemId());
                    if (item != null) item.setAvailable(false);
                    ACTIVE_LOANS_BY_ITEM.put(loan.getItemId(), loan);
                }
            } catch (RuntimeException ex) {
                System.err.println("Skipping invalid loan row: " + line);
            }
        }
    }

    private void save() throws IOException {
        storage.saveItems(getItems());
        storage.saveMembers(getMembers());
        storage.saveLoans(loans);
    }
}
