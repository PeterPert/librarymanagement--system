import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    // Конструктор инициализирует пустой список книг и журнал операций
    public Library() {
        this.books = new ArrayList<>();
        this.operationLog = new OperationLog();
    }

    // Добавьте этот метод в класс Library (после других методов)
    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            }
        }

        int borrowedBooks = totalBooks - availableBooks;

        return String.format("Общее количество книг: %d\n" +
                        "Доступно: %d\n" +
                        "Выдано: %d",
                totalBooks, availableBooks, borrowedBooks);
    }
    // Вложенный статический класс для журнала операций
    public static class OperationLog {
        // Внутренний класс для записи операции
        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;

            // конструктор
            public LogEntry(OperationType type, String description) {
                this.type = type;
                this.timestamp = LocalDateTime.now();
                this.description = description;
            }

            // геттеры
            public OperationType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public String getDescription() {
                return description;
            }

            // toString()
            @Override
            public String toString() {
                return timestamp + " [" + type + "] " + description;
            }
        }

        // Enum для типов операций
        public enum OperationType {
            ADD_BOOK, BORROW, RETURN
        }

        private List<LogEntry> entries;

        // Конструктор OperationLog
        public OperationLog() {
            this.entries = new ArrayList<>();
        }

        // методы: addEntry(), getEntries(), printLog()
        public void addEntry(OperationType type, String description) {
            LogEntry entry = new LogEntry(type, description);
            entries.add(entry);
        }

        public List<LogEntry> getEntries() {
            return new ArrayList<>(entries);
        }

        public void printLog() {
            for (LogEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    // addBook(Book book) — добавляет книгу и записывает операцию в журнал
    public void addBook(Book book) {
        books.add(book);
        operationLog.addEntry(OperationLog.OperationType.ADD_BOOK,
                "Добавлена книга: " + book.getTitle());
    }

    // findBookById(int id) — возвращает книгу по ID или null
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // findBooksByAuthor(String author) — возвращает список книг автора
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // borrowBook(int id) — выдаёт книгу (меняет available на false)
    public void borrowBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            book.setAvailable(false);
            operationLog.addEntry(OperationLog.OperationType.BORROW,
                    "Выдана книга ID: " + id);
        }
    }

    // returnBook(int id) — принимает книгу обратно
    public void returnBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            book.setAvailable(true);
            operationLog.addEntry(OperationLog.OperationType.RETURN,
                    "Возвращена книга ID: " + id);
        }
    }

    // getAvailableBooks() — возвращает список доступных книг
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    // printOperationLog() — выводит журнал всех операций
    public void printOperationLog() {
        operationLog.printLog();
    }
}