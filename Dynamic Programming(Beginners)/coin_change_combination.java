public class coin_change_combination {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 2, 3, 5, 6 };
        int amount = 7;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = arr[i];
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    dp[j] += dp[j - coin];
                }
            }
        }

        System.out.println(dp[amount]);
    }
}
