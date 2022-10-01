public class n_queens_combinations_2d_as_1d_queen_chooses {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] chess = new boolean[n][n];

        solution(0, chess, n);
    }

    private static void solution(int r, boolean[][] chess, int n) {
        if (r == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j]) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(chess, r, col)) {
                chess[r][col] = true;
                solution(r + 1, chess, n);
                chess[r][col] = false;
            }
        }
    }

    private static boolean canPlaceQueen(boolean[][] chess, int r, int c) {
        // left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j])
                return false;
        }

        // right diagonal
        for (int i = r, j = c; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j])
                return false;
        }

        // upward direction
        for (int i = r; i >= 0; i--) {
            if (chess[i][c])
                return false;
        }

        return true;
    }
}
