import java.util.*;

class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + " - " + title;
    }
}

public class CRUDCollectionDemo {
    public static void main(String[] args) {
        Map<Integer, Book> library = new HashMap<>();

        // CREATE
        library.put(1, new Book(1, "Java Basics"));
        library.put(2, new Book(2, "Advanced Java"));

        // READ
        System.out.println("Library: " + library);

        // UPDATE
        library.put(2, new Book(2, "Java Advanced Concepts"));

        // DELETE
        library.remove(1);

        System.out.println("Final Library: " + library);
    }
}
