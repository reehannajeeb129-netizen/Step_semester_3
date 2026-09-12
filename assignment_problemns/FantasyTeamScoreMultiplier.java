import java.util.Arrays;
import java.util.Scanner;

class Lineup {
    static final double CAPTAIN_MULTIPLIER = 2.0;
    static final double VICE_CAPTAIN_MULTIPLIER = 1.5;

    private double[] playerScores;

    Lineup() {
        this(new double[0]);
    }

    Lineup(double[] playerScores) {
        this.playerScores = playerScores;
    }

    double[] getScores() {
        return this.playerScores;
    }

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * CAPTAIN_MULTIPLIER;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * VICE_CAPTAIN_MULTIPLIER;
    }
}

public class FantasyTeamScoreMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        double[] scores = new double[n];
        System.out.println("Enter " + n + " player scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        System.out.print("Enter captain index: ");
        int captainIndex = sc.nextInt();

        System.out.print("Enter vice-captain index: ");
        int viceCaptainIndex = sc.nextInt();

        Lineup.applyMultipliers(scores, captainIndex, viceCaptainIndex);

        System.out.println("Updated scores: " + Arrays.toString(scores));

        sc.close();
    }
}
