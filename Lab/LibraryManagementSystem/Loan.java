import java.time.LocalDate;
public class Loan {
    private final String memberId;
    private final String itemId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    public Loan(String memberId, String itemId, LocalDate borrowDate, int loanDays) {
        this.memberId = memberId; this.itemId = itemId; this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(loanDays);
    }
    public String getMemberId() { return memberId; }
    public String getItemId() { return itemId; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isOverdue() { return LocalDate.now().isAfter(dueDate); }

    @Override public String toString() { return memberId + " borrowed " + itemId + " due " + dueDate + (isOverdue()? " OVERDUE":""); }
}