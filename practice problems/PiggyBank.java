public class PiggyBank {
    private final String id;
    private int savings = 0;

    public PiggyBank(String id) {
        this.id = id;
    }

    public void deposit(int amount) {
        if (amount > 0) savings += amount;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > savings) return false;
        savings -= amount;
        return true;
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}
