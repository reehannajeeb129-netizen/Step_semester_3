import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

interface SaverMode {
    double SAVER_REDUCTION = 0.25;

    default double applySaver(double units) {
        return units * (1 - SAVER_REDUCTION);
    }
}

abstract class Appliance {
    private static final double COST_PER_UNIT = 8;

    protected final double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract String getType();

    protected abstract double getPowerWatts();

    public double getUnits() {
        return getPowerWatts() * hours / 1000;
    }

    public static double costOf(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }

    @Override
    protected double getPowerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    protected double getPowerWatts() {
        return 1500;
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TV";
    }

    @Override
    protected double getPowerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "WASHER";
    }

    @Override
    protected double getPowerWatts() {
        return 500;
    }
}

public class Problem5_ApplianceEnergy {
    static Appliance create(String type, double hours) {
        switch (type) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AirConditioner(hours);
            case "TV":
                return new Television(hours);
            default:
                return new WashingMachine(hours);
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
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = nextLine(br).trim().split("\\s+");
            Appliance appliance = create(parts[0], Double.parseDouble(parts[1]));
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            double units = appliance.getUnits();
            if (saver) {
                if (appliance instanceof SaverMode) {
                    units = ((SaverMode) appliance).applySaver(units);
                } else {
                    System.out.println(appliance.getType() + ": saver mode not supported");
                    continue;
                }
            }
            double cost = Appliance.costOf(units);
            total += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", total);
    }
}
