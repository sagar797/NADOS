public class paint_fence {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        onSpaceApproach(n, k);
        constantSpaceApproach(n, k);
    }

    private static void constantSpaceApproach(int n, int k) {
        int same = k;
        int diff = k * (k - 1);
        int total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);
    }

    public static void onSpaceApproach(int n, int k) {
        int[][] dp = new int[3][n + 1];
        dp[0][2] = k;
        dp[1][2] = k * (k - 1);
        dp[2][2] = dp[0][2] + dp[1][2];

        for (int col = 3; col <= n; col++) {
            dp[0][col] = dp[1][col - 1];
            dp[1][col] = dp[2][col - 1] * (k - 1);
            dp[2][col] = dp[0][col] + dp[1][col];
        }

        System.out.println(dp[2][n]);
    }
}
