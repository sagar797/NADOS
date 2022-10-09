public class target_sum_subsets_dp {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 4, 2, 7, 1, 3 };
        int target = 10;

        // int n = 14;
        // int[] arr = { 4, 6, 0, 18, 12, 4, 17, 5, 5, 4, 17, 1, 20, 14 };
        // int target = 3;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j];
                    }

                    if (j - arr[i] == 0) {
                        dp[i][j] = dp[i][j - arr[i]];
                    }

                    if (j - arr[i] >= 0 && !dp[i][j]) {
                        if (!dp[i][j] && i - 1 >= 0 && dp[i - 1][j - arr[i]]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(dp[n - 1][target]);
    }
}
