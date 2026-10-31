import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Payment {
    protected final double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String getType();

    public abstract double getFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "CARD";
    }

    @Override
    public double getFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "WALLET";
    }

    @Override
    public double getFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }

    @Override
    public double getFinalAmount() {
        return amount;
    }
}

public class Problem1_PaymentSystem {
    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            default:
                return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(create(type, amount));
        }
        double total = 0;
        for (Payment p : payments) {
            double fin = p.getFinalAmount();
            total += fin;
            System.out.printf(Locale.US, "%s: %.2f%n", p.getType(), fin);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
