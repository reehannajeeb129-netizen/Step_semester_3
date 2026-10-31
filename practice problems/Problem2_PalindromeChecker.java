import java.util.Scanner;

public class Problem2_PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            boolean palindrome = word.equalsIgnoreCase(reversed);
            System.out.println(reversed + " - " + (palindrome ? "palindrome" : "not a palindrome"));
        }
    }
}
