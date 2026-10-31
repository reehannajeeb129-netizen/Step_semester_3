import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    protected final String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate getDueDate(LocalDate today);
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate today) {
        return today.plusDays(14);
    }
}

class Dvd extends LibraryItem {
    public Dvd(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate today) {
        return today.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate today) {
        return today.plusDays(3);
    }
}

public class Problem2_LibraryDueDate {
    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            default:
                return new Magazine(title);
        }
    }

    static String nextLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        return line;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(nextLine(br).trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = nextLine(br).trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            items.add(create(type, title));
        }
        LocalDate today = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(today));
        }
    }
}
