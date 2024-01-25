import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer;
    private static char opponent;
    private static boolean isHumanVsHuman;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        chooseGameMode();
        initializeBoard();
        printBoard();

        while (true) {
            playTurn();
            printBoard();

            if (checkForWin()) {
                System.out.println(currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayers();
        }

        scanner.close();
    }

    private static void chooseGameMode() {
        System.out.println("Choose game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        int choice = scanner.nextInt();

        if (choice == 1) {
            isHumanVsHuman = true;
        } else if (choice == 2) {
            isHumanVsHuman = false;
        } else {
            System.out.println("Invalid choice. Defaulting to Human vs Human.");
            isHumanVsHuman = true;
        }

        if (isHumanVsHuman) {
            currentPlayer = 'X';
            opponent = 'O';
        } else {
            System.out.println("You are 'X'. Computer is 'O'.");
            currentPlayer = 'X';
            opponent = 'O';
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playTurn() {
        if (isHumanVsHuman || currentPlayer == 'X') {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
            } else {
                System.out.println("Invalid move. Try again.");
                playTurn();
            }
        } else {
            playComputerTurn();
        }
    }

    private static void playComputerTurn() {
        System.out.println("Computer's turn:");
        Random rand = new Random();
        int row, col;

        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            return true;
        }
        return false;
    }

    private static void switchPlayers() {
        char temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
    }

    private static boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
