public class coin_change_permutations {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 2, 3, 5, 6 };
        int amount = 7;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                int coin = arr[j];
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        System.out.println(dp[amount]);
    }
}
