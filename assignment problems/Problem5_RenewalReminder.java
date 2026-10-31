import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Subscription {
    protected final String name;
    protected final LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Problem5_RenewalReminder {
    static Subscription create(String type, String name, LocalDate start) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, start);
            case "STANDARD":
                return new StandardPlan(name, start);
            default:
                return new PremiumPlan(name, start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Subscription> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            subscribers.add(create(type, name, start));
        }
        for (Subscription s : subscribers) {
            System.out.println(s.getName() + ": " + s.getRenewalDate());
        }
    }
}
