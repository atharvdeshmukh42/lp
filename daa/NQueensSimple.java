public class NQueensSimple {

    static int n;
    static int[][] board;

    static boolean isSafe(int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solve(int row) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (solve(row + 1))
                    return true;

                board[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        n = 4;
        board = new int[n][n];

        // First queen placed
        board[0][2] = 1;

        if (solve(1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
