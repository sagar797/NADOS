public class n_queens_permutations_2d_as_1d_queen_chooses {
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        boolean[] queens = new boolean[n];

        solution(0, chess, queens, 0, n);

        // solution is correct but order of answer is different in pepcoding. because
        // they have done this questions like looping over chess from start to end in
        // each iteration and check if current place is empty and can queen be placed
        // then palce a queen (which queen? qpsf+1 ie queen1 can be placed anywhere) but
        // i think it's not optimized as we have to travel complete chess board in each
        // iteration instead we can iterate on chess board only once and try to iterate
        // over queens. For example loop over queens and place each queen at arr[i][j]
        // if a queen can be placed so it saves both canQueenBePlaced function checks
        // and whole array iteration check

        System.out.println(count);
    }

    static int count = 0;

    private static void solution(int idx, int[][] chess, boolean[] queens, int qpsf, int n) {
        if (idx == n * n) {
            if (qpsf == n) {
                count++;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (chess[i][j] != 0) {
                            System.out.print("q" + chess[i][j] + "\t");
                        } else {
                            System.out.print("-\t");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        int r = idx / n;
        int c = idx % n;

        for (int i = 0; i < queens.length; i++) {
            if (!queens[i] && canPlaceQueen(chess, r, c)) {
                queens[i] = true;
                chess[r][c] = i + 1;
                solution(idx + 1, chess, queens, qpsf + 1, n);
                chess[r][c] = 0;
                queens[i] = false;
            }
        }

        solution(idx + 1, chess, queens, qpsf, n);
    }

    private static boolean canPlaceQueen(int[][] chess, int r, int c) {
        // same row
        for (int j = c; j >= 0; j--) {
            if (chess[r][j] != 0)
                return false;
        }

        // left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] != 0)
                return false;
        }

        // right diagonal
        for (int i = r, j = c; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] != 0)
                return false;
        }

        // upward direction
        for (int i = r; i >= 0; i--) {
            if (chess[i][c] != 0)
                return false;
        }

        return true;
    }
}
