public class queens_combinations_2d_as_2d_box_chooses {
    public static void main(String[] args) {
        int n = 2;
        int[][] board = new int[n][n];

        solution(0, 0, board, n * n, n);
    }

    private static void solution(int idx, int queensPlaced, int[][] board, int n, int on) {
        if (idx == n) {
            if (queensPlaced == on) {
                for (int i = 0; i < on; i++) {
                    for (int j = 0; j < on; j++) {
                        if (board[i][j] == 1) {
                            System.out.print("q");
                        } else {
                            System.out.print("-");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        int r = idx / on;
        int c = idx % on;

        board[r][c] = 1;
        solution(idx + 1, queensPlaced + 1, board, n, on);
        board[r][c] = 0;

        solution(idx + 1, queensPlaced, board, n, on);
    }
}