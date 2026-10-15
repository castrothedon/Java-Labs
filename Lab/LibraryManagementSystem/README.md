# Library Management System (Java 17+)

## Features
- Add books and DVDs
- Register members
- Borrow and return items
- Enforces a maximum of 3 active loans per member
- Book loan period: 14 days; DVD loan period: 7 days
- Search titles using streams
- List overdue loans and loan history
- Saves and reloads data using CSV files in `data/`

## Compile and run
Open a terminal in this folder and run:

```bash
javac *.java
java Main
```

The `data` folder and CSV files are created automatically. The CSV format is intentionally simple;
commas in names/titles are replaced with spaces when saved.

## Menu
1. Add book or DVD
2. Register member
3. Borrow item
4. Return item
5. List all items
6. List all members
7. List overdue items
8. Search item by title
9. List loan history
0. Save and exit
