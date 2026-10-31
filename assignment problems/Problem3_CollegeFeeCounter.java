import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected static final double NORMAL_TUITION = 40000;

    protected final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract double getTuition();

    protected double getExtraCharges() {
        return 0;
    }

    public double getFee() {
        double fee = getTuition() + getExtraCharges();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    protected double getTuition() {
        return NORMAL_TUITION;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    protected double getTuition() {
        return NORMAL_TUITION;
    }

    @Override
    protected double getExtraCharges() {
        return 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    protected double getTuition() {
        return NORMAL_TUITION / 2;
    }
}

public class Problem3_CollegeFeeCounter {
    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            default:
                return new ScholarshipStudent(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            students.add(create(type, name));
        }
        double total = 0;
        for (Student s : students) {
            double fee = s.getFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
