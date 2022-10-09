public class zero_one_knapsack {
    public static void main(String[] args) {
        // int n = 5;
        // int[] items = { 15, 14, 10, 45, 30 };
        // int[] weight = { 2, 5, 1, 3, 4 };
        // int capacity = 7;

        int n = 12;
        int[] items = { 35, 42, 31, 0, 1, 40, 29, 28, 40, 38, 40, 2 };
        int[] weight = { 3, 6, 2, 6, 6, 4, 10, 2, 7, 7, 9, 3 };
        int capacity = 9;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[index] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - weight[index]] + items[index]));
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}
