import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Delivery {
    protected final double weight;
    protected final double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getType();

    public abstract double getFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double getFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double getFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }

    @Override
    public double getFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Problem3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                default:
                    double customs = sc.nextDouble();
                    deliveries.add(new InternationalDelivery(weight, distance, customs));
                    break;
            }
        }
        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.getFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
