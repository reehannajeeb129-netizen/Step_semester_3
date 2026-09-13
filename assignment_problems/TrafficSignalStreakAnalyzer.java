public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("No signal data provided");
            return;
        }

        char longestChar = signalLog.charAt(0);
        int longestLength = 1;

        char currentChar = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentChar) {
                currentLength++;
            } else {
                currentChar = c;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestChar = currentChar;
            }
        }

        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Expected: Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Expected: Longest Streak: 'R' repeated 4 times
    }
}
