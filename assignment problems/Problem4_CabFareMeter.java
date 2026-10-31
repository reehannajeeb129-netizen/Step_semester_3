import java.util.Locale;
import java.util.Scanner;

interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    default double applyNightSurcharge(double fare) {
        return fare * (1 + NIGHT_SURCHARGE);
    }
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100;

    protected final double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract String getType();

    protected abstract double getRatePerKm();

    public final double getFare() {
        return Math.max(MINIMUM_FARE, km * getRatePerKm());
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public String getType() {
        return "MINI";
    }

    @Override
    protected double getRatePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public String getType() {
        return "SEDAN";
    }

    @Override
    protected double getRatePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    public SuvCab(double km) {
        super(km);
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    protected double getRatePerKm() {
        return 18;
    }
}

public class Problem4_CabFareMeter {
    static Cab create(String type, double km) {
        switch (type) {
            case "MINI":
                return new MiniCab(km);
            case "SEDAN":
                return new SedanCab(km);
            default:
                return new SuvCab(km);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = create(type, km);
            double fare = cab.getFare();
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).applyNightSurcharge(fare);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
