import java.util.Scanner;

public class TicTacToeAI {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char player = 'X'; // Human
    static char ai = 'O';     // AI

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tic-Tac-Toe (You = X, AI = O)");

        while (true) {
            printBoard();

            // Player move
            System.out.print("Enter row and column (0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (board[r][c] == ' ') {
                board[r][c] = player;
            } else {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (isWinner(player)) {
                printBoard();
                System.out.println("You win!");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // AI move
            int[] move = bestMove();
            board[move[0]][move[1]] = ai;

            if (isWinner(ai)) {
                printBoard();
                System.out.println("AI wins!");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    static boolean isWinner(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        return (board[0][0] == p && board[1][1] == p && board[2][2] == p) ||
               (board[0][2] == p && board[1][1] == p && board[2][0] == p);
    }

    static boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    static int[] bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = ai;
                    int score = minimax(false);
                    board[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    static int minimax(boolean isMaximizing) {
        if (isWinner(ai)) return 1;
        if (isWinner(player)) return -1;
        if (isFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = ai;
                        int score = minimax(false);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = player;
                        int score = minimax(true);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
