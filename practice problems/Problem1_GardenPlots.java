import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    protected final String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShape();

    public abstract double getArea();
}

class CirclePlot extends Plot {
    private final double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Problem1_GardenPlots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, sc.nextDouble()));
                    break;
                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plots.add(new RectanglePlot(owner, length, width));
                    break;
                default:
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plots.add(new TrianglePlot(owner, base, height));
                    break;
            }
        }
        double total = 0;
        for (Plot p : plots) {
            double area = p.getArea();
            total += area;
            System.out.printf(Locale.US, "%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
