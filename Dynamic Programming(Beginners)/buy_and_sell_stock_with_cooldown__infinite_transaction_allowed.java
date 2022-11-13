public class buy_and_sell_stock_with_cooldown__infinite_transaction_allowed {
    public static void main(String[] args) {
        int n = 12;
        int[] arr = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };

        int[][] dp = new int[n][3];

        // 1st column is for buy state
        // 2nd column is for sell state
        // 3rd column is for cooldown state
        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1], arr[i] + dp[i - 1][0]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        System.out.println(dp[n - 1][1]);
    }
}
