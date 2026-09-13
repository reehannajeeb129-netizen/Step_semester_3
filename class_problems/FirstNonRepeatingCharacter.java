import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            int occurrenceCount = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == currentCharacter) {
                    occurrenceCount++;
                }
            }

            if (occurrenceCount == 1) {
                return currentCharacter;
            }
        }

        return '\0';
    }

    public void printFirstNonRepeatingCharacter(String text) {
        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        FirstNonRepeatingCharacter finder = new FirstNonRepeatingCharacter();

        System.out.print("Enter a word or sentence: ");
        String userText = inputScanner.nextLine();

        finder.printFirstNonRepeatingCharacter(userText);
        finder.printFirstNonRepeatingCharacter("swiss");
        finder.printFirstNonRepeatingCharacter("aabbcc");

        inputScanner.close();
    }
}
