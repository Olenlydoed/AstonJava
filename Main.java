import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            var students = StudentLoader.load("students.json");

            students.forEach(Student::sortBooksByPages);

            students.forEach(System.out::println);

            students.stream()
                .flatMap(student -> student.getBooks().stream())

                .sorted(Comparator.comparingInt(Book::getPages))

                .distinct()

                .filter(book -> book.getYear() > 2000)

                .limit(3)

                .map(Book::getYear)

                .findFirst()

                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Подходящая книга отсутствует")
                );

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}