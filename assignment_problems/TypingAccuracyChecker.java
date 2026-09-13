public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < length; i++) {
            char oc = original.charAt(i);
            char tc = typed.charAt(i);
            if (oc == tc) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position
            }
        }

        double accuracy = ((double) matched / length) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matched).append("/").append(length)
              .append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPos == -1) {
            result.append(" | No Mismatches");
        } else {
            char oc = original.charAt(firstMismatchPos - 1);
            char tc = typed.charAt(firstMismatchPos - 1);
            result.append(" | First Mismatch at position ").append(firstMismatchPos)
                  .append(" ('").append(oc).append("' vs '").append(tc).append("')");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        // Expected: Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')

        checkTypingAccuracy("coding", "coding");
        // Expected: Matched: 6/6 | Accuracy: 100.00% | No Mismatches
    }
}
