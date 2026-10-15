public class Book extends LibraryItem implements Borrowable {
    private final String author;
    public Book(String id, String title, String author) {
        super(id, title); this.author = author;
    }
    public Book(String id, String title, String author, boolean available) {
        super(id, title); this.author = author; setAvailable(available);
    }
    @Override public int loanPeriodDays() { return 14; }
    public String getAuthor() { return author; }

    @Override public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if(!isAvailable()) throw new ItemNotAvailableException(getTitle() + " is not available");
        setAvailable(false);
    }
    @Override public void giveBack() { setAvailable(true); }

    @Override String toCsv() { return super.toCsv() + "," + author; }
}

class Dvd extends LibraryItem implements Borrowable {
    private final String director;
    public Dvd(String id, String title, String director) { super(id, title); this.director = director; }
    public Dvd(String id, String title, String director, boolean available) { super(id, title); this.director = director; setAvailable(available); }
    @Override public int loanPeriodDays() { return 7; }
    @Override public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if(!isAvailable()) throw new ItemNotAvailableException(getTitle() + " is not available");
        setAvailable(false);
    }
    @Override public void giveBack() { setAvailable(true); }
    @Override String toCsv() { return super.toCsv() + "," + director; }
}
