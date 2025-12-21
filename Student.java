import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private final int age;
    private final List<Book> books;

    public Student(String name, int age, List<Book> books) {
        if (books.size() < 5) {
            throw new IllegalArgumentException("У студента должно быть минимум 5 книг");
        }
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void sortBooksByPages() {
        books.sort(Comparator.comparingInt(Book::getPages));
    }

    public List<Book> getBooksAfter2000() {
        return books.stream()
                .filter(book -> book.getYear() > 2000)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(name)
          .append(", age: ").append(age)
          .append("\nBooks (after 2000):\n");

        for (Book book : getBooksAfter2000()) {
            sb.append("    ").append(book).append("\n");
        }
        return sb.toString();
    }
}