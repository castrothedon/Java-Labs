import java.util.*;
public class Member {
    private final String id;
    private final String name;
    private final List<String> borrowedItemIds = new ArrayList<>();

    public Member(String id, String name) { this.id = id; this.name = name; }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getLoanCount() { return borrowedItemIds.size(); }
    public List<String> getBorrowed() { return Collections.unmodifiableList(borrowedItemIds); }

    void addLoan(String itemId) { borrowedItemIds.add(itemId); }
    void removeLoan(String itemId) { borrowedItemIds.remove(itemId); }

    String toCsv() { return id + "," + name + "," + String.join(";", borrowedItemIds); }

    static Member fromCsv(String line) {
        String[] p = line.split(",",3);
        Member m = new Member(p[0], p[1]);
        if (p.length == 3 && !p[2].trim().isEmpty()) {
            m.borrowedItemIds.addAll(Arrays.asList(p[2].split(";")));
        }
        return m;
    }
    @Override public String toString() { return id + " - " + name + " loans=" + borrowedItemIds.size(); }
}