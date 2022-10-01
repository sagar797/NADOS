public class queens_permutations_2d_as_2d_queen_chooses {
    public static void main(String[] args) {
        int n = 2;
        int[][] chess = new int[n][n];

        solution(chess, 0, n);
    }

    private static void solution(int[][] chess, int qpsf, int n) {
        if (qpsf == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = qpsf + 1;
                    solution(chess, qpsf + 1, n);
                    chess[i][j] = 0;
                }
            }
        }
    }
}
