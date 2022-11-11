public class friends_pairing {
    public static void main(String[] args) {
        int n = 5;

        int[] dp = new int[n + 1];
        dp[2] = 2;
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
