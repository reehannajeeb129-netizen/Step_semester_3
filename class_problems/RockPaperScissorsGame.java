import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public String generateComputerMove() {
        Random randomGenerator = new Random();
        int choice = randomGenerator.nextInt(3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) {
            return "Player Wins";
        } else if (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) {
            return "Player Wins";
        } else if (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public void playGame(int totalRounds) {
        Scanner inputScanner = new Scanner(System.in);

        int winCount = 0;
        int lossCount = 0;
        int drawCount = 0;

        System.out.printf("%-8s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");

        for (int roundNumber = 1; roundNumber <= totalRounds; roundNumber++) {
            System.out.print("Round " + roundNumber + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = inputScanner.nextLine();

            String computerMove = generateComputerMove();
            String roundResult = playRound(playerMove, computerMove);

            System.out.printf("%-8d %-15s %-15s %-15s%n", roundNumber, playerMove, computerMove, roundResult);

            if (roundResult.equals("Player Wins")) {
                winCount++;
            } else if (roundResult.equals("Computer Wins")) {
                lossCount++;
            } else {
                drawCount++;
            }
        }

        double winPercentage = (winCount * 100.0) / totalRounds;

        System.out.println();
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                winCount, lossCount, drawCount, winPercentage);

        inputScanner.close();
    }

    public static void main(String[] args) {
        int totalRounds = 5;
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        game.playGame(totalRounds);
    }
}
