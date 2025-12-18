public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Добавление книг
        System.out.println("=== ДОБАВЛЕНИЕ КНИГ ===");
        library.addBook(new Book(1, "Война и мир",
                "Л.Н. Толстой", 1869, "978-5-17-090335-2"));
        library.addBook(new Book(2, "Преступление и наказание",
                "Ф.М. Достоевский", 1866, "978-5-17-090336-9"));
        library.addBook(new Book(3, "Анна Каренина",
                "Л.Н. Толстой", 1877, "978-5-17-090337-6"));

        // Поиск книги по ID
        System.out.println("\n=== ПОИСК КНИГИ ПО ID ===");
        Book foundBook = library.findBookById(2);
        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook);
        } else {
            System.out.println("Книга не найдена");
        }

        // Поиск книг по автору
        System.out.println("\n=== ПОИСК КНИГ ПО АВТОРУ ===");
        System.out.println("Книги Л.Н. Толстого:");
        for (Book book : library.findBooksByAuthor("Л.Н. Толстой")) {
            System.out.println("  - " + book.getTitle());
        }

        // Выдача книги
        System.out.println("\n=== ВЫДАЧА КНИГИ ===");
        library.borrowBook(1);
        System.out.println("Книга с ID 1 выдана");

        // Показ доступных книг
        System.out.println("\n=== ДОСТУПНЫЕ КНИГИ ПОСЛЕ ВЫДАЧИ ===");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("  - " + book.getTitle() + " (ID: " + book.getId() + ")");
        }

        // Возврат книги
        System.out.println("\n=== ВОЗВРАТ КНИГИ ===");
        library.returnBook(1);
        System.out.println("Книга с ID 1 возвращена");

        // Вывод журнала операций
        System.out.println("\n=== ЖУРНАЛ ОПЕРАЦИЙ ===");
        library.printOperationLog();
        //пишу эту строку, что изменить main
        
        // Дополнительно: покажем все доступные книги после возврата
        System.out.println("\n=== ВСЕ ДОСТУПНЫЕ КНИГИ ===");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("  - " + book);
        }
    }
}