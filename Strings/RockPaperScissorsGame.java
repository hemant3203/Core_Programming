package Strings;

import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if (user.equals("rock") && computer.equals("scissors")) return "user";
        if (user.equals("paper") && computer.equals("rock")) return "user";
        if (user.equals("scissors") && computer.equals("paper")) return "user";
        return "computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] result = new String[2][3];
        result[0][0] = "User";
        result[1][0] = "Computer";
        result[0][1] = String.valueOf(userWins);
        result[1][1] = String.valueOf(computerWins);
        result[0][2] = String.valueOf((userWins * 100) / totalGames) + "%";
        result[1][2] = String.valueOf((computerWins * 100) / totalGames) + "%";
        return result;
    }

    public static void displayResults(String[][] gameData, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < gameData.length; i++) {
            System.out.println((i + 1) + "\t" + gameData[i][0] + "\t" + gameData[i][1] + "\t\t" + gameData[i][2]);
        }
        System.out.println("\nPlayer\tWins\tWin%");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        int n = sc.nextInt();
        sc.nextLine();
        String[][] gameData = new String[n][3];

        for (int i = 0; i < n; i++) {
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            gameData[i][0] = user;
            gameData[i][1] = computer;
            gameData[i][2] = winner;

            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) computerWins++;
            else draws++;
        }

        String[][] stats = calculateStats(userWins, computerWins, n - draws);
        displayResults(gameData, stats);
        sc.close();
    }
}
