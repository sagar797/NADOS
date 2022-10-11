public class unbounded_knapsack {
    public static void main(String[] args) {
        int n = 5;
        int[] items = { 15, 14, 10, 45, 30 };
        int[] weight = { 2, 5, 1, 3, 4 };
        int capacity = 7;

        solution1D(n, items, weight, capacity);
        // solution2D(n, items, weight, capacity);
    }

    private static void solution1D(int n, int[] items, int[] weight, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int j = 0; j < weight.length; j++) {
            for (int i = 1; i < dp.length; i++) {
                int val = items[j];
                int wt = weight[j];

                if (i >= wt) {
                    int factor = dp[i - wt] + val;
                    if (factor > dp[i]) {
                        dp[i] = factor;
                    }
                }
            }
        }

        System.out.println(dp[capacity]);
    }

    private static void solution2D(int n, int[] items, int[] weight, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                int ifConsumedLeft = j - weight[index];
                if (ifConsumedLeft >= 0) {
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], (dp[i - 1][ifConsumedLeft] + items[index]));
                    }
                    dp[i][j] = Math.max(dp[i][j], (dp[i][ifConsumedLeft] + items[index]));
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}
