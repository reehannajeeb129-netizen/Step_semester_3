import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Connection {
    protected final double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract String getType();

    public abstract double getBill();
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "HOME";
    }

    @Override
    public double getBill() {
        if (units <= 100) {
            return 5 * units;
        }
        return 5 * 100 + 7 * (units - 100);
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SHOP";
    }

    @Override
    public double getBill() {
        return 8 * units + 100;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }

    @Override
    public double getBill() {
        return Math.max(1000, 6 * units);
    }
}

public class Problem4_ElectricityBilling {
    static Connection create(String type, double units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            default:
                return new FactoryConnection(units);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            connections.add(create(type, units));
        }
        double total = 0;
        for (Connection c : connections) {
            double bill = c.getBill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
