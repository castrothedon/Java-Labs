public abstract class LibraryItem {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if(id == null || id.trim().isEmpty() || title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("id and title required");
        this.id = id; this.title = title;
    }

    public abstract int loanPeriodDays(); // Book=14, DVD=7

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    String toCsv() { return id + "," + title + "," + available + "," + getClass().getSimpleName(); }

    @Override public String toString() { return id + " - " + title + " [" + (available? "Available":"Borrowed") + "]"; }
}
