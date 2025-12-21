import java.util.Objects;

public class Book {
    private final String name;
    private final String author;
    private final int pages;
    private final int year;

    public Book(String name, String author, int pages, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
               year == book.year &&
               name.equals(book.name) &&
               author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, pages, year);
    }

    @Override
    public String toString() {
        return name + " - " + author + " (" + pages + " стр., " + year + " г.)";
    }
}