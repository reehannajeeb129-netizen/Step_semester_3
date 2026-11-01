import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3_TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasDuplicateBySorting(String[] transactionIds) {
        String[] copy = transactionIds.clone();
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i].equals(copy[i - 1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] first = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] second = {"TXN2001", "TXN2002", "TXN2003"};
        System.out.println(hasDuplicate(first));
        System.out.println(hasDuplicate(second));
        System.out.println(hasDuplicateBySorting(first));
        System.out.println(hasDuplicateBySorting(second));
    }
}
