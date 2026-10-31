import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Vehicle {
    protected final int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getType();

    public abstract double getCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "BIKE";
    }

    @Override
    public double getCharge() {
        return 10.0 * hours;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "CAR";
    }

    @Override
    public double getCharge() {
        return 30.0 + 20.0 * (hours - 1);
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }

    @Override
    public double getCharge() {
        return Math.max(100.0, 50.0 * hours);
    }
}

public class Problem2_ParkingCharge {
    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            default:
                return new Truck(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(create(type, hours));
        }
        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.getCharge();
            total += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", v.getType(), charge);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
