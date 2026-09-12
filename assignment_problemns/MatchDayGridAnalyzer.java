import java.util.Scanner;

class MatchGrid {
    private final int[][] runsPerOver;
    private final int threshold;

    MatchGrid() {
        this(new int[0][0], 0);
    }

    MatchGrid(int[][] runsPerOver) {
        this(runsPerOver, 0);
    }

    MatchGrid(int[][] runsPerOver, int threshold) {
        this.runsPerOver = runsPerOver;
        this.threshold = threshold;
    }

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String label = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(label);
            if (i != runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    String classify() {
        return classifyMatches(this.runsPerOver, this.threshold);
    }
}

public class MatchDayGridAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {
            System.out.print("Enter number of overs recorded for match " + i + ": ");
            int overs = sc.nextInt();

            runsPerOver[i] = new int[overs];
            System.out.println("Enter " + overs + " over-wise runs for match " + i + ":");
            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter Power Surge threshold: ");
        int threshold = sc.nextInt();

        MatchGrid grid = new MatchGrid(runsPerOver, threshold);
        System.out.println(grid.classify());

        sc.close();
    }
}
