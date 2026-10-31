import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double getDeclaredValue();

    default double getInsurance() {
        return getDeclaredValue() * INSURANCE_RATE;
    }
}

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public abstract String getType();

    public abstract double getCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double getCharge() {
        return 40 + 10 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double getCharge() {
        return 80 + 15 * weightKg;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }

    @Override
    public double getCharge() {
        return new StandardParcel(weightKg, declaredValue).getCharge() + 50;
    }
}

public class Problem2_ParcelShipping {
    static Parcel create(String type, double weight, double value) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, value);
            case "EXPRESS":
                return new ExpressParcel(weight, value);
            default:
                return new FragileParcel(weight, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            parcels.add(create(type, weight, value));
        }
        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.getCharge();
            double insurance = 0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).getInsurance();
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
