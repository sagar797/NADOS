public class n_knights_combinations_2d_as_1d_queen_chooses {
    public static void main(String[] args) {
        int n = 2;
        boolean[][] chess = new boolean[n][n];

        solution(0, chess, 0, n);
    }

    private static void solution(int idx, boolean[][] chess, int kpsf, int n) {
        if (kpsf == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j]) {
                        System.out.print("k\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < n * n; i++) {
            int r = i / n;
            int c = i % n;

            if (canPlaceKnight(chess, r, c)) {
                chess[r][c] = true;
                solution(i + 1, chess, kpsf + 1, n);
                chess[r][c] = false;
            }
        }
    }

    private static boolean canPlaceKnight(boolean[][] chess, int r, int c) {
        int n = chess.length;
        if (r - 2 >= 0) {
            if (c - 1 >= 0 && chess[r - 2][c - 1])
                return false;

            if (c + 1 < n && chess[r - 2][c + 1])
                return false;
        }

        if (r + 2 < n) {
            if (c - 1 >= 0 && chess[r + 2][c - 1])
                return false;

            if (c + 1 < n && chess[r + 2][c + 1])
                return false;
        }

        if (c - 2 >= 0) {
            if (r - 1 >= 0 && chess[r - 1][c - 2])
                return false;

            if (r + 1 < n && chess[r + 1][c - 2])
                return false;
        }

        if (c + 2 < n) {
            if (r - 1 >= 0 && chess[r - 1][c + 2])
                return false;

            if (r + 1 < n && chess[r + 1][c + 2])
                return false;
        }

        return true;
    }
}
