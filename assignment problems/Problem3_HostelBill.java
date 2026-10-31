import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Room {
    protected final int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getType();

    public abstract double getBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SINGLE";
    }

    @Override
    public double getBill() {
        return 8.0 * units;
    }
}

class SharedRoom extends Room {
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }

    @Override
    public double getBill() {
        return 6.0 * units / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public double getBill() {
        return 10.0 * units + 200.0;
    }
}

public class Problem3_HostelBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                default:
                    rooms.add(new AcRoom(units));
                    break;
            }
        }
        double total = 0;
        for (Room r : rooms) {
            double bill = r.getBill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
