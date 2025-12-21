import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

public class StudentLoader {

    private static final Pattern STUDENT_PATTERN =
            Pattern.compile(
                    "\"name\"\\s*:\\s*\"(.*?)\"\\s*,\\s*\"age\"\\s*:\\s*(\\d+)\\s*,\\s*\"books\"\\s*:\\s*\\[(.*?)\\]",
                    Pattern.DOTALL
            );

    private static final Pattern BOOK_PATTERN =
            Pattern.compile(
                    "\"name\"\\s*:\\s*\"(.*?)\"\\s*,\\s*\"author\"\\s*:\\s*\"(.*?)\"\\s*,\\s*\"pages\"\\s*:\\s*(\\d+)\\s*,\\s*\"year\"\\s*:\\s*(\\d+)"
            );

    public static List<Student> load(String path) throws Exception {
        String content = Files.readString(Path.of(path));
        List<Student> students = new ArrayList<>();

        Matcher studentMatcher = STUDENT_PATTERN.matcher(content);

        while (studentMatcher.find()) {
            String name = studentMatcher.group(1);
            int age = Integer.parseInt(studentMatcher.group(2));
            String booksBlock = studentMatcher.group(3);

            List<Book> books = new ArrayList<>();
            Matcher bookMatcher = BOOK_PATTERN.matcher(booksBlock);

            while (bookMatcher.find()) {
                books.add(new Book(
                        bookMatcher.group(1),
                        bookMatcher.group(2),
                        Integer.parseInt(bookMatcher.group(3)),
                        Integer.parseInt(bookMatcher.group(4))
                ));
            }

            students.add(new Student(name, age, books));
        }

        return students;
    }
}