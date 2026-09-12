import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {
    static final int EXPERIENCE_ONLY_THRESHOLD = 10;
    static final int COMBINED_MATCHES_THRESHOLD = 5;
    static int totalPlayersCreated = 0;

    final String name;
    final int matchesPlayed;
    double battingAverage;
    boolean injured;

    Player() {
        this("Unknown", 0, 0.0, false);
    }

    Player(String name, int matchesPlayed, double battingAverage) {
        this(name, matchesPlayed, battingAverage, false);
    }

    Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        totalPlayersCreated++;
    }

    double fantasyPoints() {
        return this.battingAverage;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_ONLY_THRESHOLD;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= COMBINED_MATCHES_THRESHOLD && !injured;
    }

    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints(), this.fantasyPoints());
    }

    static String draftAndRank(Player[] players) {
        int draftableCount = 0;
        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftableCount++;
            }
        }

        Player[] draftable = new Player[draftableCount];
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[index] = players[i];
                index++;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].name);
            if (i != draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public String toString() {
        return this.name;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1) + ":");

            System.out.print("  Name: ");
            String name = sc.nextLine();

            System.out.print("  Matches played: ");
            int matches = sc.nextInt();

            System.out.print("  Batting average (used as fantasy points): ");
            double avg = sc.nextDouble();

            System.out.print("  Injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(name, matches, avg, injured);
        }

        System.out.println("Total players created so far: " + Player.totalPlayersCreated);

        Object firstEntry = players.length > 0 ? players[0] : null;
        if (firstEntry instanceof Player) {
            System.out.println("Draft ranking: " + Player.draftAndRank(players));
        } else {
            System.out.println("No valid players to rank.");
        }

        sc.close();
    }
}
