public class Book {
    // Поля класса (private)
    private int id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private boolean available;

    // Конструктор с параметрами
    public Book(int id, String title, String author, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.available = true; // по умолчанию книга доступна
    }

    // Геттеры для всех полей
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    // Метод для изменения статуса доступности
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Переопределённый метод toString()
    @Override
    public String toString() {
        String status = available ? "Доступна" : "Недоступна";
        return String.format(
                "[ID: %d] \"%s\" – %s (%d)\nISBN: %s | Статус: %s",
                id, title, author, year, isbn, status
        );
    }
}
