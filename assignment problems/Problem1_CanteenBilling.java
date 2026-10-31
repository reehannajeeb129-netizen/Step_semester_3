import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Customer {
    protected final double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getType();

    public abstract double getFinalAmount();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STUDENT";
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STAFF";
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "GUEST";
    }

    @Override
    public double getFinalAmount() {
        return amount + 10;
    }
}

public class Problem1_CanteenBilling {
    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            default:
                return new Guest(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            bills.add(create(type, amount));
        }
        double total = 0;
        for (Customer c : bills) {
            double fin = c.getFinalAmount();
            total += fin;
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), fin);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
