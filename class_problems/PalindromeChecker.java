import java.util.Scanner;

public class PalindromeChecker {

    public boolean isPalindromeIterative(String text) {
        String lowerText = text.toLowerCase();
        int leftIndex = 0;
        int rightIndex = lowerText.length() - 1;

        while (leftIndex < rightIndex) {
            if (lowerText.charAt(leftIndex) != lowerText.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        String lowerText = text.toLowerCase();
        return checkRecursively(lowerText, 0, lowerText.length() - 1);
    }

    private boolean checkRecursively(String text, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return true;
        }
        if (text.charAt(leftIndex) != text.charAt(rightIndex)) {
            return false;
        }
        return checkRecursively(text, leftIndex + 1, rightIndex - 1);
    }

    public boolean isPalindromeArrayReversal(String text) {
        String lowerText = text.toLowerCase();
        char[] characters = lowerText.toCharArray();
        String reversedText = "";

        for (int index = characters.length - 1; index >= 0; index--) {
            reversedText = reversedText + characters[index];
        }

        return lowerText.equals(reversedText);
    }

    public void verifyPalindrome(String text) {
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayReversalResult = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + (iterativeResult ? "Palindrome" : "Not Palindrome")
                + " | Recursive: " + (recursiveResult ? "Palindrome" : "Not Palindrome")
                + " | Array Reversal: " + (arrayReversalResult ? "Palindrome" : "Not Palindrome"));
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter text to check: ");
        String userText = inputScanner.nextLine();

        checker.verifyPalindrome(userText);
        checker.verifyPalindrome("madam");
        checker.verifyPalindrome("hello");

        inputScanner.close();
    }
}
