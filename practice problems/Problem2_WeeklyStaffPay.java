import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Staff {
    protected final String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private final double hours;
    private final double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double getPay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double getPay() {
        return stipend;
    }
}

public class Problem2_WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "FULLTIME":
                    staff.add(new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff.add(new HourlyStaff(name, hours, rate));
                    break;
                default:
                    staff.add(new InternStaff(name, sc.nextDouble()));
                    break;
            }
        }
        double total = 0;
        for (Staff s : staff) {
            double pay = s.getPay();
            total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), pay);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
