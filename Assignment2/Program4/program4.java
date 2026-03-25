import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Natural ordering by ID
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }

    public String toString() {
        return id + " - " + title;
    }
}

class TitleComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.title.compareTo(b2.title);
    }
}

public class SortBooksDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3, "Java"));
        books.add(new Book(1, "Python"));
        books.add(new Book(2, "C++"));

        // Sort by ID (Comparable)
        Collections.sort(books);
        System.out.println("Sorted by ID: " + books);

        // Sort by Title (Comparator)
        Collections.sort(books, new TitleComparator());
        System.out.println("Sorted by Title: " + books);
    }
}
