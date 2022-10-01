public class queens_combinations_2d_as_2d_queen_chooses {
    public static void main(String[] args) {
        int n = 2;
        int[][] chess = new int[n][n];

        solution(0, chess, 0, n);
    }

    private static void solution(int idx, int[][] chess, int qpsf, int n) {
        if (idx == n * n) {
            if (qpsf == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (chess[i][j] == 0) {
                            System.out.print("-\t");
                        } else {
                            System.out.print("q\t");
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

        chess[r][c] = qpsf + 1;
        solution(idx + 1, chess, qpsf + 1, n);
        chess[r][c] = 0;

        solution(idx + 1, chess, qpsf, n);
    }
}
