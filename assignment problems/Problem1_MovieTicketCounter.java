import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20;

    protected final int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();

    protected abstract double getPrice();

    public final double getAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    protected double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    protected double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    protected double getPrice() {
        return 400;
    }
}

public class Problem1_MovieTicketCounter {
    static Ticket create(String seat, int count) {
        switch (seat) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            default:
                return new ReclinerTicket(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            bookings.add(create(seat, count));
        }
        double total = 0;
        for (Ticket t : bookings) {
            double amount = t.getAmount();
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", t.getSeatType(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
