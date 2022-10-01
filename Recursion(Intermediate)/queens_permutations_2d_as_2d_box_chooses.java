public class queens_permutations_2d_as_2d_box_chooses {
    public static void main(String[] args) {
        int n = 2;
        int[][] chess = new int[n][n];
        boolean[] queens = new boolean[n];

        solution(0, chess, 0, queens, n);
    }

    private static void solution(int idx, int[][] chess, int qpsf, boolean[] queens, int n) {
        if (idx == n * n) {
            if (qpsf == n) {
                for (int i = 0; i < chess.length; i++) {
                    for (int j = 0; j < chess.length; j++) {
                        if (chess[i][j] == 0) {
                            System.out.print("-\t");
                        } else {
                            System.out.print("q" + chess[i][j] + "\t");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
            }

            return;
        }

        int r = idx / n;
        int c = idx % n;

        for (int i = 0; i < queens.length; i++) {
            if (!queens[i]) {
                queens[i] = true;
                chess[r][c] = i + 1;
                solution(idx + 1, chess, qpsf + 1, queens, n);
                chess[r][c] = 0;
                queens[i] = false;
            }
        }

        solution(idx + 1, chess, qpsf, queens, n);
    }
}
