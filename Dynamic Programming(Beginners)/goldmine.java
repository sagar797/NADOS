public class goldmine {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;

        int[][] maze = {
                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 },
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 },
                { 2, 7, 0, 8, 5, 1 }
        };

        solution(maze, m, n);
    }

    private static void solution(int[][] maze, int m, int n) {
        int[][] dp = new int[m][n];

        int max = Integer.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                if (col == 0) {
                    dp[row][col] = maze[row][col];
                } else if (row == 0) {
                    dp[row][col] = maze[row][col] + Math.max(dp[row][col - 1], dp[row + 1][col - 1]);
                } else if (row == m - 1) {
                    dp[row][col] = maze[row][col] + Math.max(dp[row][col - 1], dp[row - 1][col - 1]);
                } else {
                    dp[row][col] = maze[row][col]
                            + Math.max(dp[row][col - 1], Math.max(dp[row - 1][col - 1], dp[row + 1][col - 1]));
                }

                if (col == n - 1 && dp[row][col] > max)
                    max = dp[row][col];
            }
        }

        System.out.println(max);
    }
}
