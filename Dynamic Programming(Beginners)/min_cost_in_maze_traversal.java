public class min_cost_in_maze_traversal {
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

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1 && i == m - 1) {
                    dp[i][j] = maze[i][j];
                } else if (i == m - 1) {
                    dp[i][j] = maze[i][j] + dp[i][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = maze[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = maze[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
