import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Booking {
    private static final double BOOKING_FEE = 50;

    protected final double distanceKm;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();

    protected abstract double getBaseFare();

    public final double getTotal() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    protected double getBaseFare() {
        return 2 * distanceKm;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    protected double getBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    protected double getBaseFare() {
        return 2500 + 4 * distanceKm;
    }
}

public class Problem5_TravelBooking {
    static Booking create(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            default:
                return new FlightBooking(distanceKm);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            bookings.add(create(mode, distance));
        }
        for (Booking b : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", b.getMode(), b.getTotal());
        }
    }
}
