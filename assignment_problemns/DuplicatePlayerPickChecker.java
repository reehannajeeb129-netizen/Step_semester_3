import java.util.Scanner;

class Team {
    static final int MAX_PLAYERS = 11;

    private String teamName;
    private String[] playerNames;

    Team() {
        this("Unnamed Team", new String[0]);
    }

    Team(String[] playerNames) {
        this("Unnamed Team", playerNames);
    }

    Team(String teamName, String[] playerNames) {
        this.teamName = teamName;
        this.playerNames = playerNames;
    }

    String getTeamName() {
        return this.teamName;
    }

    String[] getPlayerNames() {
        return this.playerNames;
    }

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    static boolean isValidNameEntry(Object entry) {
        return entry instanceof String && !((String) entry).isEmpty();
    }
}

public class DuplicatePlayerPickChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players in lineup: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        System.out.println("Enter " + n + " player names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        Team team = new Team("My Fantasy XI", names);
        System.out.println("Team: " + team.getTeamName());
        System.out.println(Team.findDuplicatePick(team.getPlayerNames()));

        sc.close();
    }
}
