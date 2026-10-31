import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Journey {
    protected final double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract String getType();

    public abstract double getFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "BUS";
    }

    @Override
    public double getFare() {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }

    @Override
    public double getFare() {
        return 3 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private final double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }

    @Override
    public double getFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class Problem5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            switch (type) {
                case "BUS":
                    journeys.add(new BusJourney(distance));
                    break;
                case "TRAIN":
                    journeys.add(new TrainJourney(distance));
                    break;
                default:
                    double factor = sc.nextDouble();
                    journeys.add(new MetroJourney(distance, factor));
                    break;
            }
        }
        double total = 0;
        for (Journey j : journeys) {
            double fare = j.getFare();
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", j.getType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
