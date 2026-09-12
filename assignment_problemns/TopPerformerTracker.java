import java.util.Scanner;

class Scoreboard {
    private final int[] scores;

    Scoreboard() {
        this(new int[0]);
    }

    Scoreboard(int[] scores) {
        this.scores = scores;
    }

    int[] getScores() {
        return this.scores;
    }

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
}

public class TopPerformerTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        Scoreboard board = new Scoreboard(scores);
        System.out.println(Scoreboard.findMinMaxSpread(board.getScores()));

        sc.close();
    }
}
