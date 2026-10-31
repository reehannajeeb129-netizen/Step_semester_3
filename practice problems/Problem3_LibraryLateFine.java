import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;
    protected final int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double getFine() {
        return 2.0 * daysLate;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double getFine() {
        return Math.min(50.0, 5.0 * daysLate);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double getFine() {
        return 1.0 * daysLate;
    }
}

public class Problem3_LibraryLateFine {
    static LibraryItem create(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DvdItem(title, daysLate);
            default:
                return new MagazineItem(title, daysLate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            items.add(create(type, title, daysLate));
        }
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.getFine();
            total += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
