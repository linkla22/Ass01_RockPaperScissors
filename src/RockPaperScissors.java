import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            // Get move choice from playerA
            System.out.print("Player A, enter your move (R/P/S): ");
            String playerA = getValidMove(scanner);

            // Get move choice from playerB
            System.out.print("Player B, enter your move (R/P/S): ");
            String playerB = getValidMove(scanner);

            // Display results
            displayResults(playerA, playerB);

            // Prompt user to play again
            System.out.print("Do you want to play again? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
    }

    private static String getValidMove(Scanner scanner) {
        String move;
        do {
            move = scanner.next();
            if (!isValidMove(move)) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!isValidMove(move));
        return move.toUpperCase();
    }

    private static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S");
    }

    private static void displayResults(String playerA, String playerB) {
        System.out.println("Player A chose: " + playerA);
        System.out.println("Player B chose: " + playerB);

        if (playerA.equals(playerB)) {
            System.out.println("It's a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println("Player A wins! " + getResultPhrase(playerA, playerB));
        } else {
            System.out.println("Player B wins! " + getResultPhrase(playerB, playerA));
        }
    }

    private static String getResultPhrase(String winnerChoice, String loserChoice) {
        switch (winnerChoice) {
            case "R":
                return "Rock breaks Scissors";
            case "P":
                return "Paper covers Rock";
            case "S":
                return "Scissors cuts Paper";
            default:
                return "Invalid choices";
        }
    }
}
