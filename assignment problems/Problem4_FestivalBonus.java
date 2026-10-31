import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double getBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double getBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double getBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }
}

public class Problem4_FestivalBonus {
    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            default:
                return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees.add(create(type, name, salary));
        }
        double total = 0;
        for (Employee e : employees) {
            double bonus = e.getBonus();
            total += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", e.getName(), bonus);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
